package com.zhb.cloud.core.threadlocal;

import com.zhb.cloud.mybatis.sys.model.User;

public class UserThreadLocal {

	// 声明ThreadLocal
	private static ThreadLocal<User> userThreadLocal = new ThreadLocal<User>();

	// 把user放入到ThreadLocal中
	public static void set(User user) {
		userThreadLocal.set(user);
	}

	// 从ThreadLocal中获取用户信息
	public static User get() {
		return userThreadLocal.get();
	}

}
