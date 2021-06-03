package com.banknext.screening.svc.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.banknext.txn.Entity;


@Service
public class ScreeningService {

	Log LOGGER = LogFactory.getLog(ScreeningService.class);
		
	public String  entityScreening() {
		
		String isScreeningPass = "false";
	    	try {
	    		
	    		LOGGER.info("---- screening processing ...." );	    
	    		
	    		Thread.sleep(8000); //artificial delay - simulate processing	    		
	    		isScreeningPass = "true";
	    		
	    		LOGGER.info("---- screening completed" );
	    		
			} catch (InterruptedException e) {				
				LOGGER.error("---- screening error occurred " + e );
				LOGGER.info("---- screening result " + isScreeningPass);
			}
	    	
	    	LOGGER.info("---- screening pass " + isScreeningPass);
	        return isScreeningPass;	        
	}
}