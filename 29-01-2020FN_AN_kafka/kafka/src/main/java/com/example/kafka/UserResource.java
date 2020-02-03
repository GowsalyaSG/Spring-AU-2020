package com.example.kafka;

import java.util.Properties;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/mykafka")
public class UserResource {
	private final Producer producer;

	@Autowired
	public UserResource(Producer producer) {
		this.producer = producer;
	}

	@PostMapping(value = "/published")
	public void sendMessageToKafkaTopic(@RequestParam("message") String message) {

		Properties props = new Properties();
		props.put("metadata.broker.list", "localhost:9092");
		props.put("topic.metadata.refresh.interval.ms", "2");
		props.put("serializer.class", "kafka.serializer.StringEncoder");
		props.put("partitioner.class", "raggieKafka.SimplePartitioner");
		props.put("request.required.acks", "1");

		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				Random random = new Random();
                //random number between 1 to 1000
				int number1 = getRandomInteger(1000, 1);
				System.out.println(number1);
				producer.sendMessage(number1 + "");
			}

			//by using function to get random integer
			
			public int getRandomInteger(int maximum, int minimum) {
				return ((int) (Math.random() * (maximum - minimum))) + minimum;
			}

		}, 0, 2000);
	}
}
