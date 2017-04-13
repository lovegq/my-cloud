package com.zhb.cloud.core.listener;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zhb.cloud.mybatis.sys.model.User;

/**
 * @Title: RabbitListener.java
 * @Package com.zhb.rabbit.listener
 * @Description: 消息监听
 * @author zhb
 * @date 2016年11月25日 下午4:24:14
 * @version V1.0
 */
public class RabbitListener {
	Logger logger = LoggerFactory.getLogger(RabbitListener.class);
	private Queue<User> users = new PriorityBlockingQueue<User>(100, new QuoteComparator());
	private long timeout = 30000;

	/**
	 * @Title: handleMessage
	 * @Description: 监听收集的信息并做对应的处理
	 * @return: void
	 * @author: zhb
	 * @throws 2016年11月28日上午11:04:14
	 */
	public void handleMessage(User user) {
		long timestamp = System.currentTimeMillis() - timeout;
		logger.info("监听到的的消息是:" + user.toString());
		for (Iterator<User> iterator = users.iterator(); iterator.hasNext();) {
			User model = iterator.next();
			if (model == null) {
				iterator.remove();
			} else if (model.getRegisterTime().getTime() < timestamp) {
				iterator.remove();
			}
		}
		users.add(user);
	}

	public Queue<User> getUsers() {
		return users;
	}

	private static class QuoteComparator implements Comparator<User> {
		public int compare(User o1, User o2) {
			return new Long(o1.getRegisterTime().getTime() - o2.getRegisterTime().getTime()).intValue();
		}
	}
}
