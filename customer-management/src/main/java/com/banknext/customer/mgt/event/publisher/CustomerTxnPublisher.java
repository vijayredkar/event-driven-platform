package com.banknext.customer.mgt.event.publisher;

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
public class CustomerTxnPublisher {
	
	@Value("${new-customer-created-topic}")
	String custTxnTopic;
	
	@Autowired
	private KafkaTemplate<String, Entity> customerKafkaTemplate;
	
	Log LOGGER = LogFactory.getLog(CustomerTxnPublisher.class);
		
	public void publish(Entity entity) 
	{
		customerKafkaTemplate.send(custTxnTopic, entity);
		LOGGER.info("---- Message published - Customer created : " +  entity.toString());
    }
}