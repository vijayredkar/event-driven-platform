package com.banknext.customer.mgt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banknext.customer.mgt.event.publisher.CustomerTxnPublisher;
import com.banknext.txn.Customer;


/*----------------- only for tests --------------------*/

@RestController
@RequestMapping(value = "/customer-initiator/")
public class CustomerMgtController {

	/*
	 * @Autowired CustomerTxnPublisher custTxnPub;
	 * 
	 * @PostMapping(value = "/new") public String producer(@RequestBody Customer
	 * customer) {
	 * 
	 * 
	 * custTxnPub.publish(customer); return "Event published - Customer : "
	 * +customer.toString();
	 * 
	 * }
	 */

}