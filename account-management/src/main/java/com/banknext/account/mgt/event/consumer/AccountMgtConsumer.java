package com.banknext.account.mgt.event.consumer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.banknext.account.mgt.event.publisher.AccountTxnPublisher;
import com.banknext.txn.Account;
import com.banknext.txn.Entity;


@Component

public class AccountMgtConsumer {
		
	Log LOGGER = LogFactory.getLog(AccountMgtConsumer.class);
	@Autowired
	AccountTxnPublisher acctTxnPub;
	
	/*
	 * @KafkaListener(topics = "${new-customer-created-topic}") public void
	 * listen(Customer customer) {
	 * LOGGER.info("---- Message consumed - Customer created : "+
	 * customer.toString()); }
	 */
	
	@KafkaListener(topics = "${new-customer-created-topic}")
    public void listen(Entity entity)
    {        
    	LOGGER.info("---- Message consumed - Customer created : "+ entity.getCustomer().toString());    	
    	processMessage(entity);
    }

	private void processMessage(Entity entity) {		
		
		Account account = entity.getAccount();
		LOGGER.info("---- Processing message account : "+ account.toString());
		createAccountEntity(account);
		acctTxnPub.publish(entity);
	}

	private void createAccountEntity(Account account) 
	{
		LOGGER.info("---- Message processed - New account created : "+ account.toString());	
	}
}