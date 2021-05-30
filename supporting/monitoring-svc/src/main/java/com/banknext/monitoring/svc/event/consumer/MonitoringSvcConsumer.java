package com.banknext.monitoring.svc.event.consumer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.banknext.txn.Account;
import com.banknext.txn.Entity;


@Component

public class MonitoringSvcConsumer {
		
	Log LOGGER = LogFactory.getLog(MonitoringSvcConsumer.class);
	
	@KafkaListener(topics = "${new-customer-created-topic}")
    public void listen(Entity entity)
    {        
    	LOGGER.info("---- Message consumed - New Customer-Account created : "+ entity.toString());    	
    	processMessage(entity);
    }

	private void processMessage(Entity entity) {	
		monitor(entity);
	}

	private void monitor(Entity entity) {		
		LOGGER.info("---- Moitoring - Customer-Account " + entity.toString());		
	}
}