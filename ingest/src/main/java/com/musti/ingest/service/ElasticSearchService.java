package com.musti.ingest.service;

import org.springframework.stereotype.Service;

import com.musti.ingest.model.FeedbackES;
import com.musti.ingest.model.StoreTargetList;
import com.musti.ingest.model.TransactionIndex;

@Service
public interface ElasticSearchService {
	
	/**
	 * This method receives the Transaction Index and prepares all the prerequisites to establish a connection with the Elastic Search Repository and 
	 * passes the required information for the repository to complete the persistence
	 * @param transactionIndex
	 * @return
	 */
	Boolean saveTransaction(TransactionIndex transactionIndex); 
	
	/**
	 * This method receives the list of Store Targets and sets up an Async call to thread out the process of pushing to Elastic Search 
	 * Required URL and the Headers are supplied by this method to repository to complete the Rest Template Invocation
	 * @param list
	 * @return
	 */
	Boolean saveTargets(StoreTargetList list); 
	
	Boolean saveFeedback(FeedbackES feedbackEs); 

}
