package com.banknext.notification.svc.event.consumer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.banknext.txn.Account;
import com.banknext.txn.Entity;


@Component

public class NotificationSvcConsumer {
		
	Log LOGGER = LogFactory.getLog(NotificationSvcConsumer.class);
	
	@KafkaListener(topics = "${new-account-created-topic}")
    public void listen(Entity entity)
    {        
    	LOGGER.info("---- Message consumed - New Customer-Account created : "+ entity.getCustomer().toString());    	
    	processMessage(entity);
    }

	private void processMessage(Entity entity) {		
		
		Account account = entity.getAccount();
		LOGGER.info("---- Processing message account : "+ account.toString());
		notify(entity);
	}

	private void notify(Entity entity) {		
		LOGGER.info("---- Notified - Customer and Account ready for transaction " + entity.toString());		
	}
}