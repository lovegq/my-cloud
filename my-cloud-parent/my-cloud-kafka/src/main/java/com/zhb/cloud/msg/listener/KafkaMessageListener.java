package com.zhb.cloud.msg.listener;

import java.util.Optional;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

public class KafkaMessageListener {
	Logger logger = LoggerFactory.getLogger(KafkaMessageListener.class);

	@KafkaListener(id = "asddsda", topics = "test", group = "zhb", containerFactory = "kafkaListenerContainerFactory")
	public void listener(ConsumerRecord<String, String> record) {
		Optional<String> message = Optional.ofNullable(record.value());
		if (message.isPresent()) {
			String str = message.get();
			System.out.println(str);
		}
		logger.info(record.value());
		System.out.println(record);
	}

}