package com.zhb.cloud.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

import com.zhb.cloud.msg.listener.KafkaMessageListener;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title: KafkaConsumerConfig.java
 * @Package com.zhb.cloud.config
 * @Description:kafka生产者配置
 * @author zhb
 * @date 2016年11月23日 下午5:28:32
 * @version V1.0
 */
@Configuration
@AutoConfigureAfter(KafkaProducerConfig.class)
@EnableKafka
public class KafkaConsumerConfig {
	public static final String KAFKA_GROUP = "zhb";
	@Value("${spring.cloud.kafka.binder.brokers}")
	private String KAFKA_SERVER;
	public static final String KAFKA_TOPIC = "test";

	/**
	 * @Title: kafkaListenerContainerFactory
	 * @Description: 消息监听
	 * @return
	 * @return: KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String,String>>
	 * @author: zhb
	 * @throws 2016年11月29日下午3:50:59
	 */
	public @Bean KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, String>> kafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory());
		factory.setConcurrency(3);
		factory.getContainerProperties().setPollTimeout(3000);
		return factory;
	}

	/**
	 * @Title: consumerFactory
	 * @Description:消费者工厂
	 * @return
	 * @return: ConsumerFactory<String,String>
	 * @author: zhb
	 * @throws 2016年11月29日下午3:50:08
	 */
	public @Bean ConsumerFactory<String, String> consumerFactory() {
		return new DefaultKafkaConsumerFactory<>(consumerConfigs());
	}

	/**
	 * @Title: consumerConfigs
	 * @Description: 消费者配置
	 * @return
	 * @return: Map<String,Object>
	 * @author: zhb
	 * @throws 2016年11月29日下午3:50:27
	 */
	public @Bean Map<String, Object> consumerConfigs() {
		Map<String, Object> propsMap = new HashMap<>();
		propsMap.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KAFKA_SERVER);
		propsMap.put(ConsumerConfig.GROUP_ID_CONFIG, KAFKA_GROUP);
		propsMap.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
		propsMap.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
		propsMap.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "15000");
		propsMap.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		propsMap.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		propsMap.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
		return propsMap;
	}

	/**
	 * @Title: messageListener
	 * @Description: 消息监听
	 * @return: KafkaMessageListener
	 * @author: zhb
	 * @throws 2016年11月29日下午4:14:19
	 */
	public @Bean KafkaMessageListener messageListener() {
		return new KafkaMessageListener();
	}
}