package com.zhb.cloud.core.utils;

import java.util.UUID;

/**
 * @Title: UUIDUtil.java
 * @Package com.tztd.sts.core.util
 * @Description: uuid的工具类
 * @author zhb
 * @date 2016年5月5日 下午6:00:05
 * @version V1.0
 */
public class UUIDUtil {
	public static String getId() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
