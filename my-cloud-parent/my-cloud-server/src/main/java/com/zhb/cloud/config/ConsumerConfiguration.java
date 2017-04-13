package com.zhb.cloud.config;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zhb.cloud.core.converter.RabbitMessageConverter;
import com.zhb.cloud.core.listener.RabbitListener;

/**
 * @Title: ConsumerConfiguration.java
 * @Package com.zhb.rabbit.config
 * @Description: 消费者配置
 * @author zhb
 * @date 2016年11月25日 下午5:15:27
 * @version V1.0
 */
@Configuration
public class ConsumerConfiguration {
	// 连接工厂
	@Autowired
	private ConnectionFactory connectionFactory;
	protected final String queue = "test.queue1";

	/**
	 * @Title: listenerContainer
	 * @Description: 消息监听器
	 * @return
	 * @return: SimpleMessageListenerContainer
	 * @author: zhb
	 * @throws 2016年11月28日上午9:19:38
	 */
	public @Bean SimpleMessageListenerContainer listenerContainer() {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.setQueueNames(this.queue);
		MessageListenerAdapter listenerAdapter = new MessageListenerAdapter(new RabbitListener(),
				new RabbitMessageConverter());
		container.setMessageListener(listenerAdapter);
		return container;
	}

}
