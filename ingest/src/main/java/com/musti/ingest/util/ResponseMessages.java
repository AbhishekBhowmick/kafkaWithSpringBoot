package com.musti.ingest.util;

public interface ResponseMessages {
	
	public interface ErrorMessages {
		final String COMMON_ERROR ="Some internal error occurs";
		final Integer MUSTI_ERROR_ID = 9999;
		final String STORE_USER = "User and Store mapped error Please add and try again";
		final String STORE_TIMING = "Store Timing creation error Please add and try again";
		final String STORE_UPDATE_CREATE = "Store not created or updated some internal error occurs";
		final String STORE_ALREADY_EXIST = " Store already exist";
		final String STORE_EXIST ="Stores does not exists";
		final String STORE_NOT_EXIST ="user does not have any Stores";
		final String PARAMETER_MISMATCHED ="Request parameter mismatched";
		final String NO_STORES_IN_COUNTRY ="No stores available for the country ";
        final String SAME_DATE_RANGE ="Start date and End date should be in the same month";
		
	}
	
	public interface SuccessMessages { 
		final String STORE_USER = "User and  Store successfully mapped" ;
		final String STORE_TIMING = "Store Times entered successfully" ;
	}

}
