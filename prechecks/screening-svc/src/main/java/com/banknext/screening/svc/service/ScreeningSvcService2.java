package com.banknext.screening.svc.service;

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


@Service
public class ScreeningSvcService2 {

	Log LOGGER = LogFactory.getLog(ScreeningSvcService2.class);
		
	/*
	 * public CompletableFuture<String> process2() {
	 * 
	 * LOGGER.info("---- process2 initiated" );
	 * 
	 * //String result = "process2 completed"; //return
	 * CompletableFuture.completedFuture(result);
	 * 
	 * CompletableFuture.runAsync( () -> {
	 * 
	 * LOGGER.info("---- process2 running ...." );
	 * 
	 * }
	 * 
	 * );
	 * 
	 * String result = "process2 completed"; return
	 * CompletableFuture.completedFuture(result); }
	 */
	
	@Async
	public CompletableFuture<String> process2() {
		
		LOGGER.info("---- process2 initiated" );
		
		String result = "process2 completed";
		return CompletableFuture.completedFuture(result);
	}
	
	
	
	public CompletableFuture<String>  thenApplyAsyncExample_trial() {
		
		String a = null ;
		
	    //CompletableFuture<String> cf = CompletableFuture.completedFuture("process2").thenApplyAsync(s -> {
		CompletableFuture<Void> cf = CompletableFuture.runAsync(() -> {
	        
	    	
	    	try {
	    		
	    		LOGGER.info("---- process2 initiated" );	    		
				/*
				 * LOGGER.info("---- process2 processing ...." ); Thread.sleep(2000);
				 * LOGGER.info("---- process2 completed" );
				 */
		    	
		    	
//		    	throw new Exception();
		    	
		    	
			} catch (Exception e) {
				
				LOGGER.info("---- process2 error " + e );
				e.printStackTrace();
			}
	    	
	    	
	        //return s.toUpperCase();
	    });
	
		a.charAt(1);
		
	    return CompletableFuture.completedFuture("process2M");
	}
	
	public CompletableFuture<String>  thenApplyAsyncExample() {
		
	    //CompletableFuture<String> cf = CompletableFuture.completedFuture("process2").thenApplyAsync(s -> {
		CompletableFuture<Void> cf = CompletableFuture.runAsync(() -> {
	        
	    	
	    	try {
	    		
	    		LOGGER.info("---- process2 initiated" );	    		
				
			    LOGGER.info("---- process2 processing for 2 seconds ...." ); 
			    Thread.sleep(2000);
			    
			    LOGGER.info("---- process2 completed" );
				 
		    	
			} catch (Exception e) {
				
				LOGGER.info("---- process2 error " + e );
				e.printStackTrace();
			}
	    });
		
	    return CompletableFuture.completedFuture("process2");
	}

}