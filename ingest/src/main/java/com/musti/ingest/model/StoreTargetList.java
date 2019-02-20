package com.musti.ingest.model;

import java.util.List;

/**
 * List of objects which needs to be stored in the Elastic Search Repository has been packaged and wrapped in this model. 
 * @author Darshan Nagesh
 *
 */

public class StoreTargetList {
	
	private List<StoreTargetES> targetList;

	public List<StoreTargetES> getTargetList() {
		return targetList;
	}

	public void setTargetList(List<StoreTargetES> targetList) {
		this.targetList = targetList;
	} 
	
	 

}
