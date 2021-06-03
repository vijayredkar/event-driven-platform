package com.banknext.deduplication.svc.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banknext.deduplication.svc.service.DeduplicationService;
import com.banknext.txn.Entity;

@RestController
@RequestMapping(value = "/deduplication-initiator/")
public class DeduplicationSvcController {
	
	Log LOGGER = LogFactory.getLog(DeduplicationSvcController.class);
	
	@Autowired
	DeduplicationService deduplicationSvc;
	
	@GetMapping(value = "/new")
	public String screen() {
			
		return deduplicationSvc.entityDuplicateCheck();
	}
}