package com.musti.ingest.model;

/**
 * Index Object which has the Trasnaction Object wrapped up for better indexing in ES
 * @author Darshan Nagesh
 *
 */
public class TransactionIndex {
	
	private Transaction transaction;

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}
	
	
	
}
