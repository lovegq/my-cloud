package com.zhb.cloud;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyCloudKafkaApplicationTests {
	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;

	/***
	 * @Title: sendMsg
	 * @Description:消息发送者 void
	 * @author: zhb
	 * @throws 2016年11月24日上午9:32:40
	 */
	@Test
	public void sendMsg() {
		// 生产者发送信息
		kafkaTemplate.send("test", "username", "zhangsan");
	}

	@Test
	public void reciveMsg() {
		// 生产者发送信息
	}
}
