package com.musti.ingest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Transaction Object which gets posted to Elastic Search 
 * @author Darshan Nagesh
 *
 */
public class Transaction {

	@JsonProperty("TransactionId")
	private Long transactionId;
	@JsonProperty("ReceiptNo")
	private String receiptNo;
	@JsonProperty("TransType")
	private String transType;
	@JsonProperty("StoreId")
	private Long storeId;
	@JsonProperty("PosTerminalNo")
	private String posTerminalNo;
	@JsonProperty("StaffId")
	private Long staffId;
	@JsonProperty("TransDate")
	private String transDate;
	@JsonProperty("TransTime")
	private String transTime;
	@JsonProperty("CustomerNo")
	private Long consumerNo;
	@JsonProperty("SalesType")
	private String salesType;
	@JsonProperty("NetAmt")
	private Double netAmt;
	@JsonProperty("GrossAmt")
	private Double grossAmt;
	@JsonProperty("Payment")
	private Double payment;
	@JsonProperty("DiscountAmt")
	private Double discountAmt;
	@JsonProperty("CostAmt")
	private Double costAmt;
	@JsonProperty("ManagerId")
	private Long managerId;
	@JsonProperty("IsTraining")
	private Boolean isTraining;
	@JsonProperty("StatementNo")
	private String statementNo;
	@JsonProperty("PostingStatus")
	private String postingStatus;
	@JsonProperty("PostStatementNo")
	private String postStatementNo;

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public String getReceiptNo() {
		return receiptNo;
	}

	public void setReceiptNo(String receiptNo) {
		this.receiptNo = receiptNo;
	}

	public String getTransType() {
		return transType;
	}

	public void setTransType(String transType) {
		this.transType = transType;
	}

	public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public String getPosTerminalNo() {
		return posTerminalNo;
	}

	public void setPosTerminalNo(String posTerminalNo) {
		this.posTerminalNo = posTerminalNo;
	}

	public Long getStaffId() {
		return staffId;
	}

	public void setStaffId(Long staffId) {
		this.staffId = staffId;
	}

	public String getTransDate() {
		return transDate;
	}

	public void setTransDate(String transDate) {
		this.transDate = transDate;
	}

	public String getTransTime() {
		return transTime;
	}

	public void setTransTime(String transTime) {
		this.transTime = transTime;
	}

	public Long getConsumerNo() {
		return consumerNo;
	}

	public void setConsumerNo(Long consumerNo) {
		this.consumerNo = consumerNo;
	}

	public String getSalesType() {
		return salesType;
	}

	public void setSalesType(String salesType) {
		this.salesType = salesType;
	}

	public Double getNetAmt() {
		return netAmt;
	}

	public void setNetAmt(Double netAmt) {
		this.netAmt = netAmt;
	}

	public Double getGrossAmt() {
		return grossAmt;
	}

	public void setGrossAmt(Double grossAmt) {
		this.grossAmt = grossAmt;
	}

	public Double getPayment() {
		return payment;
	}

	public void setPayment(Double payment) {
		this.payment = payment;
	}

	public Double getDiscountAmt() {
		return discountAmt;
	}

	public void setDiscountAmt(Double discountAmt) {
		this.discountAmt = discountAmt;
	}

	public Double getCostAmt() {
		return costAmt;
	}

	public void setCostAmt(Double costAmt) {
		this.costAmt = costAmt;
	}

	public Long getManagerId() {
		return managerId;
	}

	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}

	public Boolean getIsTraining() {
		return isTraining;
	}

	public void setIsTraining(Boolean isTraining) {
		this.isTraining = isTraining;
	}

	public String getStatementNo() {
		return statementNo;
	}

	public void setStatementNo(String statementNo) {
		this.statementNo = statementNo;
	}

	public String getPostingStatus() {
		return postingStatus;
	}

	public void setPostingStatus(String postingStatus) {
		this.postingStatus = postingStatus;
	}

	public String getPostStatementNo() {
		return postStatementNo;
	}

	public void setPostStatementNo(String postStatementNo) {
		this.postStatementNo = postStatementNo;
	}
}
