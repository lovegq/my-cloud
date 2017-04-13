package com.zhb.cloud.config;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import static org.springframework.amqp.core.BindingBuilder.bind;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Title: ProducerConfiguration.java
 * @Package com.zhb.rabbit.config
 * @Description: 生产者配置
 * @author zhb
 * @date 2016年11月28日 上午11:31:55
 * @version V1.0
 */
@Configuration
public class ProducerConfiguration {
	@Autowired
	// 连接工厂
	private ConnectionFactory connectionFactory;
	protected final String queueName = "test.queue1";
	protected final String routingKey = "zhb.route";
	protected final String exchange = "zhb.exchange";

	/**
	 * @Title: rubeExchange
	 * @Description: 交换机--看作是信息的生产者producer 生产者发送消息的地方
	 * @return: DirectExchange
	 * @param: @return
	 * @author: zhb
	 * @throws 2016年4月14日下午3:01:53
	 */
	public @Bean DirectExchange exchange() {
		// 参数1 --交换机名称 参数 2 -- 是否持久化 参数 3 ---是否自动删除
		return new DirectExchange(this.exchange, true, false);
	}

	/**
	 * @Title: queue
	 * @Description: 队列--消费者通过queue来接收信息
	 * @return: Queue
	 * @param: @return
	 * @author: zhb
	 * @throws 2016年4月14日下午3:03:16
	 */
	public @Bean Queue queue() {
		// 参数1 --队列的名称 参数2 --- 是否持久化
		return new Queue(this.queueName, true);
	}

	/**
	 * @Title: exchangeBinding
	 * @Description: 将queue绑定到交换机 :也就是说将生产者端绑定到一个具体的队列,消费者就可以从此接收
	 *               消息是怎么通过路由(交换机)从生产者到特定的消费者的
	 * @return: Binding
	 * @param: @return
	 * @author: zhb
	 * @throws 2016年4月14日下午3:08:32
	 */
	public @Bean Binding exchangeBinding() {
		return bind(queue()).to(exchange()).with(this.routingKey);
	}

	/**
	 * @Title: messageConverter
	 * @Description: 使用自带的消息转换器
	 * @return
	 * @return: MessageConverter
	 * @author: zhb
	 * @throws 2016年12月13日下午1:52:46
	 */
	// public @Bean MessageConverter messageConverter() {
	// return new JsonMessageConverter();
	// }

	/**
	 * @Title: rabbitTemplate
	 * @Description:返回操作模板
	 * @return: RabbitTemplate
	 * @param: @return
	 * @author: zhb
	 * @throws 2016年4月14日下午3:08:54
	 */
	public @Bean RabbitTemplate rabbitTemplate() {
		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setRoutingKey(this.routingKey);
		rabbitTemplate.setExchange(this.exchange);
		rabbitTemplate.setQueue(this.queueName);
		return rabbitTemplate;
	}

	/**
	 * @Title: rabbitMessagingTemplate
	 * @Description:消息模板
	 * @return: RabbitMessagingTemplate
	 * @param: @return
	 * @author: zhb
	 * @throws 2016年4月14日下午3:09:39
	 */
	public @Bean RabbitMessagingTemplate rabbitMessagingTemplate() {
		return new RabbitMessagingTemplate(rabbitTemplate());
	}

	/**
	 * @Title: amqpAdmin
	 * @Description: 用来管理 队列和交换机
	 * @return: AmqpAdmin
	 * @param: @return
	 * @author: zhb
	 * @throws 2016年4月14日下午3:11:42
	 */
	public @Bean AmqpAdmin amqpAdmin() {
		return new RabbitAdmin(connectionFactory);
	}
}
