package com.musti.ingest.service;

import static java.util.concurrent.CompletableFuture.supplyAsync;

import java.nio.charset.Charset;
import java.util.Date;

import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import com.musti.ingest.model.FeedbackES;
import com.musti.ingest.model.StoreTargetES;
import com.musti.ingest.model.StoreTargetList;
import com.musti.ingest.model.Transaction;
import com.musti.ingest.model.TransactionIndex;
import com.musti.ingest.repository.ElasticSearchRepository;

/**
 * This is a Service Implementation for all the actions which are with respect to Elastic Search 
 * @author Darshan Nagesh
 *
 */
@Service("elasticSearchService")
public class ElasticSearchServiceImpl implements ElasticSearchService {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(ElasticSearchServiceImpl.class);
	
	@Autowired
	private ElasticSearchRepository elasticRepository;
	
	private static final String AUTHORIZATION = "Authorization";
	private static final String US_ASCII = "US-ASCII";
	private static final String BASIC_AUTH = "Basic %s";
	private final String indexServiceHost;
	private final String userName;
	private final String password;
	private final String indexName;
	private final String documentType;
	private final String storeTargetIndex; 
	private final String storeTargetDocType; 
	private final String feedbackIndex;
	private final String feedbackDocType; 

	public ElasticSearchServiceImpl(
			@Value("${musti.services.esindexer.host}") String indexServiceHost,
			@Value("${musti.services.esindexer.username}") String userName,
			@Value("${musti.services.esindexer.password}") String password, @Value("${es.index.name}") String indexName,
			@Value("${es.index.name.storeTarget}") String storeTargetIndex, @Value("${es.document.type.storeTarget}") String storeTargetDocType,
			@Value("${es.index.name.feedback}") String feedbackIndex, @Value("${es.document.type.feedback}") String feedbackDocType,
			@Value("${es.document.type}") String documentType) {
		this.indexServiceHost = indexServiceHost;
		this.userName = userName;
		this.password = password;
		this.indexName = indexName;
		this.documentType = documentType;
		this.storeTargetDocType = storeTargetDocType; 
		this.storeTargetIndex = storeTargetIndex;
		this.feedbackIndex = feedbackIndex; 
		this.feedbackDocType = feedbackDocType; 
	}

	@Override
	public Boolean saveTransaction(TransactionIndex transactionIndex) {
		structureTransactionData(transactionIndex);
		String url = String.format("%s%s/%s/%s", this.indexServiceHost, indexName, documentType,
				transactionIndex.getTransaction().getTransactionId());
		HttpHeaders headers = getHttpHeaders();
		LOGGER.info("Transaction Index to be added to ES : " + transactionIndex);
		LOGGER.info("URL to invoke : " + url);
		
		return elasticRepository.saveTransaction(transactionIndex, url, headers);

	}

	private void structureTransactionData(TransactionIndex index) { 
		Transaction transaction = index.getTransaction(); 
		
		// Converting and setting the Receipt Number as the Transaction ID 
		if(transaction.getTransactionId() == null || transaction.getTransactionId() <= 0) { 
			String storeCode = String.valueOf(transaction.getStoreId()); 
			transaction.setTransactionId(Long.valueOf(transaction.getReceiptNo().concat(storeCode)));
		}
		
		// Concatenating the Transaction Time and Date into Transaction Date Field 
		String transDate = transaction.getTransDate(); 
		String transTime = transaction.getTransTime();
		String[] transTimes = transTime.split(":");
		if (transTimes[0].length()==1) {
			transTime = "0".concat(transTime);
			transaction.setTransTime(transTime);
		}
		transaction.setTransDate(transDate.concat("T").concat(transTime));
	}
	
	
	@Override
	public Boolean saveTargets(StoreTargetList list) {
		try {
			supplyAsync(() -> {
				Boolean update = true;
				HttpHeaders headers = getHttpHeaders();
				for(StoreTargetES eachTarget : list.getTargetList()) {
					String url = String.format("%s%s/%s/%s", this.indexServiceHost, storeTargetIndex, storeTargetDocType, eachTarget.getId());
					LOGGER.info("Transaction Index to be added to ES : " + eachTarget.toString());
					LOGGER.info("URL to invoke : " + url);
					elasticRepository.saveTarget(eachTarget, url, headers);
				}
				return update;
			});
		} catch (Exception e) { 
			LOGGER.error("Encountered an error while pushing data to Elastic : " + e);
		}
		return true; 
	}
	
	/**
	 * A helper method to create the headers for Rest Connection with UserName and Password
	 * @return HttpHeaders
	 */
	private HttpHeaders getHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.add(AUTHORIZATION, getBase64Value(userName, password));
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }
    
	/**
	 * Helper Method to create the Base64Value for headers
	 * @param userName
	 * @param password
	 * @return
	 */
    private String getBase64Value(String userName, String password) {
        String authString = String.format("%s:%s", userName, password);
        byte[] encodedAuthString = Base64.encodeBase64(authString.getBytes(Charset.forName(US_ASCII)));
        return String.format(BASIC_AUTH, new String(encodedAuthString));
    }

	@Override
	public Boolean saveFeedback(FeedbackES feedbackEs) {
		try {
			supplyAsync(() -> {
				Boolean update = true;
				HttpHeaders headers = getHttpHeaders();
					String url = String.format("%s%s/%s/%s", this.indexServiceHost, feedbackIndex, feedbackDocType, new Date().getTime());
					LOGGER.info("Feedback to be added to ES : " + feedbackEs.toString());
					LOGGER.info("URL to invoke : " + url);
					elasticRepository.saveFeedback(feedbackEs, url, headers);
				return update;
			});
		} catch (Exception e) { 
			LOGGER.error("Encountered an error while pushing data to Elastic : " + e);
		}
		return true; 
	}
}
