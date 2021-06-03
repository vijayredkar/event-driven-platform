package com.banknext.entity.mgt.service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.banknext.txn.Entity;


@Service
@EnableAsync
public class PrechecksServiceAsync {

	Log LOGGER = LogFactory.getLog(PrechecksServiceAsync.class);
	
	@Value("${screening-svc-url}")
	String urlScreeningSvc;
	
	@Value("${deduplication-svc-url}")
	String urlDeduplicationSvc;
	
				
	@Async
	public CompletableFuture<String> isScreeningPassAsync(Entity entity) {
		
		CompletableFuture cfScreeningRsp = null;
		
		try {
			
			RestTemplate restTemplate = new RestTemplate();
			cfScreeningRsp = CompletableFuture.completedFuture(restTemplate.getForEntity(urlScreeningSvc, String.class));
	
		} catch (Exception e) {
			
			LOGGER.info("---- PrechecksServiceAsync screening failed " + e );
		}
		
		return cfScreeningRsp;
	}
	
	
	@Async
	public CompletableFuture<String> isDuplicateAsync(Entity entity) {		
		
		CompletableFuture cfDedupRsp = null;
		
		try {
			
			RestTemplate restTemplate = new RestTemplate();
			cfDedupRsp = CompletableFuture.completedFuture(restTemplate.getForEntity(urlDeduplicationSvc, String.class));
	
		} catch (Exception e) {
			
			LOGGER.info("---- PrechecksServiceAsync duplicateCheck failed " + e );
		}
		
		return cfDedupRsp;
	}
}