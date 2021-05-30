package com.banknext.notification.svc.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.banknext.txn.Customer;

@EnableKafka
@Configuration
public class ConsumerConfiguration {
	
    @Value("${spring.kafka.consumer.group-id}")
    private String groupId;
    @Value("${spring.kafka.bootstrap-servers}")
    private String brokers;
        
    
    @Bean
    public ConsumerFactory consumerFactory(){
    Map<String, Object> customerConfigMap = new HashMap<>();
    customerConfigMap.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,brokers);
    customerConfigMap.put(ConsumerConfig.GROUP_ID_CONFIG,groupId);
    customerConfigMap.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
    customerConfigMap.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
    customerConfigMap.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
    customerConfigMap.put(JsonDeserializer.REMOVE_TYPE_INFO_HEADERS,true);
    return new DefaultKafkaConsumerFactory<>(customerConfigMap);
    }
    
    
    @Bean
    KafkaListenerContainerFactory<ConcurrentMessageListenerContainer> kafkaListenerContainerFactory() 
    {
        ConcurrentKafkaListenerContainerFactory factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }
}