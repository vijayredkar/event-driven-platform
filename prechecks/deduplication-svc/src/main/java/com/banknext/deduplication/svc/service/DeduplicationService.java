package com.banknext.deduplication.svc.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.banknext.txn.Entity;


@Service
public class DeduplicationService {

	Log LOGGER = LogFactory.getLog(DeduplicationService.class);
	
	public String  entityDuplicateCheck() {
		
		String isDuplicate = "true";
	    	try {
	    		
	    		LOGGER.info("---- duplication check processing ...." );	    		
	    		Thread.sleep(3000); //artificial delay - simulate processing
	    		
	    		isDuplicate = "false";
	    		
	    		LOGGER.info("---- duplication check  completed" );
	    		
			} catch (InterruptedException e) {				
				LOGGER.error("---- duplication check  error occurred " + e );
				LOGGER.info("---- is duplicate " + isDuplicate);	    
			}
	    	
	    	LOGGER.info("---- is duplicate " + isDuplicate);
	        return isDuplicate;	        
	}
}