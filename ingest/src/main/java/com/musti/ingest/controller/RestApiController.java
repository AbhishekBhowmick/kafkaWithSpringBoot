package com.musti.ingest.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.musti.ingest.model.FeedbackES;
import com.musti.ingest.model.StoreTargetList;
import com.musti.ingest.model.Transaction;
import com.musti.ingest.model.TransactionIndex;
import com.musti.ingest.service.ElasticSearchService;
import com.musti.ingest.util.Constants;
import com.musti.ingest.util.ResponseGenerator;

@RestController
@RequestMapping(Constants.Paths.ELASTIC_PUSH_CONTROLLER_PATH)
public class RestApiController {

	public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

	@Autowired
	ElasticSearchService elasticSearchService; 

	/**
	 * This API receives the Transaction Details JSON Request and passes it on to the Service Layer for
	 * further process of persisting into elastic search database
	 * @param transaction
	 * @return
	 */
	@KafkaListener(topics = "Kafka_Example_json", group = "group_json",
			containerFactory = "userKafkaListenerFactory")
	public ResponseEntity<?> save(@RequestBody Transaction transaction) {
		logMyTime();
		logger.info("Adding a Transaction : {}", transaction.toString());
		TransactionIndex index = new TransactionIndex();
		if(transaction != null) { 
			index.setTransaction(transaction);
		}
		Boolean status = elasticSearchService.saveTransaction(index);
		if(status) { 
			return new ResponseEntity<String>(HttpStatus.CREATED);
		}
		return new ResponseEntity<String>(HttpStatus.SERVICE_UNAVAILABLE);
	}
	
	private void logMyTime() {
		logger.info("System Time is : " + new Date());
		SimpleDateFormat sd = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");
		Date date = new Date();
		sd.setTimeZone(TimeZone.getTimeZone("IST"));
		logger.info("Time at timezone IST : " + sd.format(date));
	}

	

}