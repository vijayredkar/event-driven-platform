package com.banknext.entity.mgt.service;

import java.util.concurrent.CompletableFuture;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.banknext.txn.Entity;


@Service
public class PrechecksService {

	Log LOGGER = LogFactory.getLog(PrechecksService.class);
		
	@Autowired
	PrechecksServiceAsync preChkSvcAsync;
	
	/* 
	 * invoke multiple pre-check services in parallel
	 * 
	 */
	public boolean performPrechecks(Entity entity) {
		
		boolean isPrecheckPass = false;		
		
		try {
			
			RestTemplate restTemplate = new RestTemplate();
			
		//---- sequential calls to multiple REST services
		   /* 
			ResponseEntity<String> rspScreeningSvc = restTemplate.getForEntity(urlScreeningSvc, String.class);
			LOGGER.info("---- Prechecks Screening response : "+ rspScreeningSvc.getBody() );
			
			
			ResponseEntity<String> rspDedupSvc = restTemplate.getForEntity(urlDeduplicationSvc, String.class);
			LOGGER.info("---- Prechecks Deduplication response : "+ rspDedupSvc.getBody() );
			
			if("true".equals(rspScreeningSvc) && "false".equals(rspDedupSvc))
			{
				isPrecheckPass = true;
			}
			
			*/
						
		//-- parallel Async invocations
			CompletableFuture cfScreeningRsp = preChkSvcAsync.isScreeningPassAsync(entity);
			CompletableFuture cfDedupRsp = preChkSvcAsync.isDuplicateAsync(entity);
			
			CompletableFuture.allOf(cfScreeningRsp, cfDedupRsp).join();
			
			
			LOGGER.info("\n---- Prechecks invocations start");
			
			ResponseEntity<String> screeningRsp = (ResponseEntity<String>) cfScreeningRsp.get();
			ResponseEntity<String> dedupRsp = (ResponseEntity<String>) cfDedupRsp.get();
			
			LOGGER.info("\n---- Prechecks invocations finished");
			
			if("true".equals(screeningRsp.getBody()) && "false".equals(dedupRsp.getBody()))
			{
				LOGGER.info("\n---- Prechecks passed");
				isPrecheckPass = true;
			}
			else
			{
				LOGGER.info("\n---- Prechecks failed");				
			}
			
		} catch (Exception e) {
			
			LOGGER.info("---- PrechecksService failed " + e );
		}
		
		return isPrecheckPass;
	}
}