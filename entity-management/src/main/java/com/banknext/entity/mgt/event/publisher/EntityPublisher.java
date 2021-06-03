package com.banknext.entity.mgt.event.publisher;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

//import com.banknext.customer.mgt.dto.Customer;
import com.banknext.txn.Customer;
import com.banknext.txn.Entity;

@Service
public class EntityPublisher {
	
	@Value("${new-entity-initiated-topic}")
	String entityTxnTopic;
	
	@Autowired
	private KafkaTemplate<String, Entity> entityKafkaTemplate;
	
	Log LOGGER = LogFactory.getLog(EntityPublisher.class);
		
	/*
	 * public void publish(Customer customer) {
	 * customerKafkaTemplate.send(entityTxnTopic, customer);
	 * LOGGER.info("---- Message published - Entity initiated : " +
	 * customer.toString()); }
	 */
	
	public void publish(Entity entity) 
	{
		entityKafkaTemplate.send(entityTxnTopic, entity);
		LOGGER.info("---- Message published - Entity initiated : " +  entity.toString());
    }
	
	
}