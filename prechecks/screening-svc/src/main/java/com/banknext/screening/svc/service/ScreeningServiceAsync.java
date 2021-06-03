package com.banknext.screening.svc.service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ScreeningServiceAsync {

	Log LOGGER = LogFactory.getLog(ScreeningServiceAsync.class);
	
	@Autowired
	ScreeningSvcService1 screeningSvc1;
	
	@Autowired
	ScreeningSvcService2 screeningSvc2;
		
	public void collateData() {
		
		String defaultResult = "default";
		
		try {
			
			CompletableFuture<String> cf1 = screeningSvc1.thenApplyAsyncExample()
														//.orTimeout(5, TimeUnit.SECONDS)
														.exceptionally(throwable -> defaultResult);
			
			CompletableFuture<String> cf2 = screeningSvc2.thenApplyAsyncExample()
														.exceptionally(throwable -> defaultResult);
			
			CompletableFuture.allOf(cf1, cf2)
								//.orTimeout(5, TimeUnit.SECONDS)
								.join();
			
			String result2 = cf2.get();
			String result1 = cf1.get();			
			
			LOGGER.info("---- ScreeningSvcService result1 : " + result1 );
			LOGGER.info("---- ScreeningSvcService result2 : " + result2 );
			
		} catch (Exception e) {
			
			LOGGER.info("---- ScreeningSvcService failed" );
		}
	}
	
	
	
	public CompletableFuture<String>  screen() {
		
	    CompletableFuture<String> cf = CompletableFuture.completedFuture("screen").thenApplyAsync(s -> {
	        
	    	try {
	    		LOGGER.info("---- screening initiated" );
	    		LOGGER.info("---- screening processing for 8 seconds ...." );
				
	    		Thread.sleep(8000);
				
	    		LOGGER.info("---- screening completed" );
			} catch (InterruptedException e) {
				
				LOGGER.error("---- screening error occurred " + e );				
				return "fail";
			}
	    	
	        return "pass";
	        
	    });
	    
	    return cf;
	}
}