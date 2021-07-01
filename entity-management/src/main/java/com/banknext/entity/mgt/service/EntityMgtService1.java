package com.banknext.entity.mgt.service;

import java.util.concurrent.CompletableFuture;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.classic.Logger;


@Service
public class EntityMgtService1 {

	Log LOGGER = LogFactory.getLog(EntityMgtService1.class);
		
	@Async
	public CompletableFuture<String> process1() throws Exception {
		
		LOGGER.info("---- process1 initiated" );
		
		
		//test with delay		
		  try 
		  { 
			  Thread.sleep(8000); 
		  } 
		  catch (InterruptedException e) 
		  {
			  LOGGER.error("---- Thread interupted error "); 
		  }
		 
		/*
		 * String a = "a"; if(!a.equals("b")) { throw new
		 * Exception(" EntityMgtService1  error "); }
		 */ 
				
		  String result = "process1 completed"; 
		  
		  return  CompletableFuture.completedFuture(result);
		 
		
		/*
		 * String result = "process1 completed"; CompletableFuture.runAsync(process8());
		 * 
		 * 
		 * return null;
		 */
	}

	/*
	 * private Runnable process8() { LOGGER.info("---- process1 running...." );
	 * return null; }
	 */

	
	public CompletableFuture<String>  thenApplyAsyncExample() {
	    CompletableFuture<String> cf = CompletableFuture.completedFuture("process1").thenApplyAsync(s -> {
	        
	    	try {
	    		LOGGER.info("---- process1 initiated" );
	    		LOGGER.info("---- process1 processing for 8 seconds ...." );
				
	    		Thread.sleep(8000);
				
	    		LOGGER.info("---- process1 completed" );
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    		    	
	        return s.toUpperCase();
	    });
	    
	    return cf;
	}
	
	public CompletableFuture<String>  invokeScreening() 
	{
		
	    CompletableFuture<String> cf = CompletableFuture.completedFuture("process1").thenApplyAsync(s -> {
	        
	    	try {
	    		LOGGER.info("---- process1 initiated" );
	    		LOGGER.info("---- process1 processing for 8 seconds ...." );
				
	    		Thread.sleep(8000);
				
	    		LOGGER.info("---- process1 completed" );
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    		    	
	        return s.toUpperCase();
	    });
	    
	    return cf;
	}
}