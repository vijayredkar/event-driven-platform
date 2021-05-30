package com.banknext.account.mgt.event.publisher;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.banknext.txn.Account;
import com.banknext.txn.Entity;

@Service
public class AccountTxnPublisher {
	
	@Value("${new-account-created-topic}")
	String newAcctCreatedTopic;
	
	@Autowired
	private KafkaTemplate<String, Entity> acctKafkaTemplate;
	
	Log LOGGER = LogFactory.getLog(AccountTxnPublisher.class);
		
	/*
	 * public void publish(Customer customer) {
	 * customerKafkaTemplate.send(newAcctCreatedTopic, customer);
	 * LOGGER.info("---- Message published - Account created : " +
	 * customer.toString()); }
	 */
	
	
	public void publish(Entity entity) 
	{
		acctKafkaTemplate.send(newAcctCreatedTopic, entity);
		LOGGER.info("---- Message published - Account created : " +  entity.getAccount().toString());
    }	
}