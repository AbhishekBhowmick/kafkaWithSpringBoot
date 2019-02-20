package com.musti.ingest.model;

import java.util.Date;

/**
 * Model which indicates the specific attributes which needs to be stored in Elastic Search Repository
 * @author Darshan Nagesh
 *
 */

public class StoreTargetES {
	
	private String storeCode;
	private Date targetDate;
	private String dateTarget; 
	private Double salesValue;
	private Double receiptsValue;
	private Double avgValue;
	private Long version; 
	private Long id ;
	
	public String getDateTarget() {
		return dateTarget;
	}
	public void setDateTarget(String dateTarget) {
		this.dateTarget = dateTarget;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getVersion() {
		return version;
	}
	public void setVersion(Long version) {
		this.version = version;
	}
	public String getStoreCode() {
		return storeCode;
	}
	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}
	public Date getTargetDate() {
		return targetDate;
	}
	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}
	public Double getSalesValue() {
		return salesValue;
	}
	public void setSalesValue(Double salesValue) {
		this.salesValue = salesValue;
	}
	public Double getReceiptsValue() {
		return receiptsValue;
	}
	public void setReceiptsValue(Double receiptsValue) {
		this.receiptsValue = receiptsValue;
	}
	public Double getAvgValue() {
		return avgValue;
	}
	public void setAvgValue(Double avgValue) {
		this.avgValue = avgValue;
	} 
	
	
}
