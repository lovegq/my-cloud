package com.zhb.cloud.config;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title: KafkaProducerConfig.java
 * @Package com.zhb.cloud.config
 * @Description: kafka消费者配置
 * @author zhb
 * @date 2016年11月23日 下午5:28:58
 * @version V1.0
 */
@Configuration
@EnableKafka
public class KafkaProducerConfig {
	public static final String KAFKA_GROUP = "zhb";
	@Value("${spring.cloud.kafka.binder.brokers}")
	private String KAFKA_SERVER;
	public static final String KAFKA_TOPIC = "test";
	Logger log = LoggerFactory.getLogger(KafkaProducerConfig.class);

	public @Bean ProducerFactory<String, String> producerFactory() {
		DefaultKafkaProducerFactory<String, String> kafkaProducerFactory = new DefaultKafkaProducerFactory<>(
				producerConfigs());
		return kafkaProducerFactory;
	}

	public @Bean Map<String, Object> producerConfigs() {
		Map<String, Object> props = new HashMap<>();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KAFKA_SERVER);
		props.put(ProducerConfig.RETRIES_CONFIG, 0);
		props.put(ProducerConfig.RETRIES_CONFIG, 0);
		props.put(ProducerConfig.BATCH_SIZE_CONFIG, 16384);
		props.put(ProducerConfig.LINGER_MS_CONFIG, 1);
		props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 33554432);
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		return props;
	}

	public @Bean KafkaTemplate<String, String> kafkaTemplate() {
		return new KafkaTemplate<String, String>(producerFactory());
	}
}