package com.banknext.entity.mgt.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banknext.entity.mgt.event.publisher.EntityPublisher;
import com.banknext.entity.mgt.service.PrechecksService;
import com.banknext.txn.Entity;


@RestController
@RequestMapping(value = "/event-initiator/")
public class EntityMgtController {

	Log LOGGER = LogFactory.getLog(EntityMgtController.class);
	
	@Autowired
	EntityPublisher eventTxnPub;
	@Autowired
	PrechecksService prechecksSvc;
		
	@PostMapping(value = "/new")
	public ResponseEntity<String> handle(@RequestBody Entity entity) {
		
		LOGGER.info("\n---- Entity onboarding initiated");
		
		//prechecks
		boolean checksPassed = prechecksSvc.performPrechecks(entity);
		String response = null;
		
		
		//event processing
		if(checksPassed)
		{
			LOGGER.info("\n---- Prechecks passed. Publishing event for further processing");
			eventTxnPub.publish(entity);
			response = "Success - Entity published : \n" +entity.toString();
			return new ResponseEntity<String>(response, HttpStatus.OK);
		}
		else
		{
			LOGGER.info("\n---- Prechecks failed. Entity onboarding aborted");
			response = "Enitity onboarding cannot proceed - Mandatory checks failed";
			return new ResponseEntity<String>(response, HttpStatus.BAD_REQUEST);
		}		
	}
}