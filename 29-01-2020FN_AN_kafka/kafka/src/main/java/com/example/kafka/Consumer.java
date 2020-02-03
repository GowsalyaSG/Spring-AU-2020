package com.example.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {
	private final Logger logger = LoggerFactory.getLogger(Consumer.class);

	@KafkaListener(topics = "topic1", groupId = "group_id")
	public void consume(String msg) {

		System.out.println("message :" + msg);
		
		logger.info(String.format("Receiving from Broker: " + msg));
	}
}
