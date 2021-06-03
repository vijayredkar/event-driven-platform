package com.banknext.screening.svc.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banknext.screening.svc.service.ScreeningService;
import com.banknext.txn.Entity;

@RestController
@RequestMapping(value = "/screening-initiator/")
public class ScreeningController {
	
	Log LOGGER = LogFactory.getLog(ScreeningController.class);
	
	@Autowired
	ScreeningService screeningSvc;
	
	@GetMapping(value = "/new")
	public String screen() 
	{			
		return screeningSvc.entityScreening();
	}

}