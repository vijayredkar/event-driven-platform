package com.banknext.customer.mgt.event.consumer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.banknext.customer.mgt.event.publisher.CustomerTxnPublisher;
//import com.banknext.customer.mgt.dto.Customer;
import com.banknext.txn.Customer;
import com.banknext.txn.Entity;


@Component
public class EntityTxnConsumer {
	
	Log LOGGER = LogFactory.getLog(EntityTxnConsumer.class);
	
	@Autowired
	CustomerTxnPublisher custTxnPub;
	
    @KafkaListener(topics = "${new-entity-initiated-topic}")
    //public void listen(Customer customer) 
    public void listen(Entity entity)
    {        
    	LOGGER.info("---- Message consumed - Entity initiated : "+ entity.toString());
    	
    	processMessage(entity);
    }

	private void processMessage(Entity entity) {		
		
		Customer customer = entity.getCustomer();
		LOGGER.info("---- Processing message customer : "+ customer.toString());
		createCustomerEntity(customer);
		custTxnPub.publish(entity);
	}

	private void createCustomerEntity(Customer customer) 
	{
		LOGGER.info("---- Message processed - New customer created : "+ customer.toString());	
	}
}