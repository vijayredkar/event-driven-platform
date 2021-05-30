package com.banknext.entity.mgt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banknext.entity.mgt.event.publisher.EntityPublisher;
import com.banknext.txn.Customer;
import com.banknext.txn.Entity;


@RestController
@RequestMapping(value = "/event-initiator/")
public class EntityMgtController {

	@Autowired
	EntityPublisher eventTxnPub;
	/*
	 * @PostMapping(value = "/new") public String producer(@RequestBody Customer
	 * customer) {
	 * 
	 * eventTxnPub.publish(customer);
	 * 
	 * return "Entity published - Entity : " +customer.toString(); }
	 */
	
	

	@PostMapping(value = "/new")
	public String producer(@RequestBody Entity entity) {
	
		eventTxnPub.publish(entity);		
		return "Entity published - Entity : " +entity.toString();
	}

}