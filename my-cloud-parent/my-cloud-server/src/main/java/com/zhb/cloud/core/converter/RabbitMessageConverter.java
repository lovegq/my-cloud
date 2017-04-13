package com.zhb.cloud.core.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.support.converter.AbstractMessageConverter;

import com.alibaba.fastjson.JSONObject;
import com.zhb.cloud.mybatis.sys.model.User;

/**
 * @Title: AmqpLogMessageConverter.java
 * @Package com.zhb.rabbit.core.converer
 * @Description: 自定义的消息转换器
 * @author zhb
 * @date 2016年11月28日 上午11:50:31
 * @version V1.0
 */
public class RabbitMessageConverter extends AbstractMessageConverter {
	Logger logger = LoggerFactory.getLogger(RabbitMessageConverter.class);

	@Override
	protected Message createMessage(Object object, MessageProperties properties) {
		throw new UnsupportedOperationException("转换异常");
	}

	/**
	 * 将传递过来的消息进行转换
	 */
	@Override
	public Object fromMessage(Message message) {
		String str = new String(message.getBody());
		return JSONObject.parseObject(str, User.class);
	}
}
