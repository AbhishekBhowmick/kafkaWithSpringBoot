package com.musti.ingest.repository;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.musti.ingest.model.FeedbackES;
import com.musti.ingest.model.StoreTargetES;
import com.musti.ingest.model.TransactionIndex;

/**
 * This Repository Class is used to perform the transactions of storing the data into the Elastic Search Repository 
 * @author Darshan Nagesh
 *
 */
@Service
public class ElasticSearchRepository {

	public static final Logger LOGGER = LoggerFactory.getLogger(ElasticSearchRepository.class);

    private final RestTemplate restTemplate;
    
	public ElasticSearchRepository(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	/**
	 * Based on the Transaction Index Data Obtained and the URL with Headers, this method will put the Data obtained on the
	 * Elastic Search Database and returns the response in the form of Positive or Negative outcome (True Or False) 
	 * @param transactionIndex
	 * @param url
	 * @param headers
	 * @return
	 */
	public Boolean saveTransaction(TransactionIndex transactionIndex, String url, HttpHeaders headers) {
		ResponseEntity<Map> map = null;
		try {
			map = restTemplate.exchange(url, HttpMethod.PUT,
					new HttpEntity<>(transactionIndex.getTransaction(), headers), Map.class);
		} catch (final HttpClientErrorException httpClientErrorException) {
			LOGGER.error("Error : " + httpClientErrorException);
		} catch (HttpServerErrorException httpServerErrorException) {
			LOGGER.error("Error : " + httpServerErrorException);
		} catch (Exception e) {
			LOGGER.error("Error : " + e);
		}
		if (map != null && map.getStatusCode() != null && (map.getStatusCode() == HttpStatus.OK) || (map.getStatusCode() == HttpStatus.CREATED)) {
			return true;
		}
		return false;
	}
	
	
	/**
	 * Save Target Method will receive the Elastic Search Object with URL and appropriate headers. 
	 * This method will exchange the Target Object with the Rest Call to the URL to push the data object to Elastic Search 
	 * @param eachTarget
	 * @param url
	 * @param headers
	 * @return
	 */
	public Boolean saveTarget(StoreTargetES eachTarget, String url, HttpHeaders headers) {
		ResponseEntity<Map> map = null;
		try {
			LOGGER.info("Each Target : " + eachTarget.toString()); 
			map = restTemplate.exchange(url, HttpMethod.PUT,
					new HttpEntity<>(eachTarget, headers), Map.class);
		} catch (final HttpClientErrorException httpClientErrorException) {
			LOGGER.error("Error : " + httpClientErrorException);
		} catch (HttpServerErrorException httpServerErrorException) {
			LOGGER.error("Error : " + httpServerErrorException);
		} catch (Exception e) {
			LOGGER.error("Error : " + e);
		}
		if (map != null && map.getStatusCode() != null && (map.getStatusCode() == HttpStatus.OK) || (map.getStatusCode() == HttpStatus.CREATED)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Save Target Method will receive the Elastic Search Object with URL and appropriate headers. 
	 * This method will exchange the Target Object with the Rest Call to the URL to push the data object to Elastic Search 
	 * @param feedbackEs
	 * @param url
	 * @param headers
	 * @return
	 */
	public Boolean saveFeedback(FeedbackES feedbackEs, String url, HttpHeaders headers) {
		ResponseEntity<Map> map = null;
		try {
			LOGGER.info("Each Target : " + feedbackEs.toString()); 
			map = restTemplate.exchange(url, HttpMethod.PUT,
					new HttpEntity<>(feedbackEs, headers), Map.class);
		} catch (final HttpClientErrorException httpClientErrorException) {
			LOGGER.error("Error : " + httpClientErrorException);
		} catch (HttpServerErrorException httpServerErrorException) {
			LOGGER.error("Error : " + httpServerErrorException);
		} catch (Exception e) {
			LOGGER.error("Error : " + e);
		}
		if (map != null && map.getStatusCode() != null && (map.getStatusCode() == HttpStatus.OK) || (map.getStatusCode() == HttpStatus.CREATED)) {
			return true;
		}
		return false;
	}

}
