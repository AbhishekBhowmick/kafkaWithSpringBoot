package com.musti.ingest.util;

/**
 * Constants which are with respect to the Ingest App
 * @author Darshan Nagesh
 *
 */

public interface Constants {
	public interface Paths { 
		final String ELASTIC_PUSH_CONTROLLER_PATH = "/elastic" ; 
		final String SAVE_TRANSACTION = "/save"; 
		final String SAVE_TARGETS = "/saveTargets";
		final String SAVE_FEEDBACK = "/saveFeedback"; 
		final String SAVE_FEEDBACK_RESPONSE = "/v1/saveFeedback"; 
	}
	
	public static String SUCCESS= "success";
	public static int UNAUTHORIZED_ID = 401;
	public static int SUCCESS_ID = 200;
	public static int FAILURE_ID = 320;
	public static String UNAUTHORIZED = "Invalid credentials. Please try again.";
	public static String PROCESS_FAIL = "Process failed, Please try again.";

}
