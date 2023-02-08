package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import com.demo.models.User;
import com.google.gson.Gson;

@Service
public class Producer {
	
	@Autowired
	Gson gson;
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public ListenableFuture<SendResult<String, String>> sendMessageToTopic(User message) {
		return kafkaTemplate.send("TestTopic", gson.toJson(message));
	}

}
