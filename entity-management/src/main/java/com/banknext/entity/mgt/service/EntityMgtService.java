package com.banknext.entity.mgt.service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EntityMgtService {

	Log LOGGER = LogFactory.getLog(EntityMgtService.class);
	
	@Autowired
	EntityMgtService1 entityMgtSvc1;
	
	@Autowired
	EntityMgtService2 entityMgtSvc2;
		
	public void collateData() {
		
		String defaultResult = "default";
		
		try {
			
			//CompletableFuture<String> cf1 = entityMgtSvc1.process1()
														//.orTimeout(5, TimeUnit.SECONDS)
														//.exceptionally(throwable -> defaultResult);
			
			
			CompletableFuture<String> cf1 = entityMgtSvc1.thenApplyAsyncExample()
														//.orTimeout(5, TimeUnit.SECONDS)
														.exceptionally(throwable -> defaultResult);
			
			
			//CompletableFuture<String> cf2 = entityMgtSvc2.process2()
														//.exceptionally(throwable -> defaultResult);
			CompletableFuture<String> cf2 = entityMgtSvc2.thenApplyAsyncExample()
														.exceptionally(throwable -> defaultResult);
			
			CompletableFuture.allOf(cf1, cf2)
								//.orTimeout(5, TimeUnit.SECONDS)
								.join();
			
			String result2 = cf2.get();
			String result1 = cf1.get();
			
			
			LOGGER.info("---- EntityMgtService result1 : " + result1 );
			LOGGER.info("---- EntityMgtService result2 : " + result2 );
			
		} catch (Exception e) {
			
			LOGGER.info("---- EntityMgtService failed" );
		}
	}
}