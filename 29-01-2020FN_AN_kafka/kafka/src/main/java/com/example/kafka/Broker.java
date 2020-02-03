package com.example.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Broker {
		private final Logger logger = LoggerFactory.getLogger(Broker.class);
		
		private String msg;
		
		private static final String TOPIC = "topic1";
		
		@Autowired
		private KafkaTemplate<String, String> kafkaTemplate;

		@KafkaListener(topics = "topic2", groupId = "group_id")
		public void consumeMediator(String msg) {
			
            //converting into int
			int i=Integer.valueOf(msg); 
			int i2=msg.length(); 
			
			System.out.println(i+" "+i2);  
			if(i % 2 == 0) {

				this.msg = i + "";
			} 
			else {

				this.msg = i2 + "";
			}
			System.out.println("checking message "+msg);
			
			logger.info(String.format(this.msg));
			
			this.sendMessage();
		}
		
		public void sendMessage() {
			
			logger.info(String.format("Msg in Broker: "+ this.msg));
			
			this.kafkaTemplate.send(TOPIC, this.msg);
		}
	}
