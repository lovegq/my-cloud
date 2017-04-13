package com.zhb.cloud.core.utils;

/**
 * @Title: RetCode.java
 * @Package com.tztd.sts.core.constant
 * @Description: 异步请求的返回值定义
 * @author zhb
 * @date 2016年5月5日 下午5:55:51
 * @version V1.0
 */
public class RetCode {
	/**
	 * 正确code
	 */
	public final static String OK_CODE = "200";
	/**
	 * 错误code
	 */
	public final static String ERROR_CODE = "400";
	/**
	 * 正确msg
	 */
	public final static String OK_MSG = "请求成功";
	/***
	 * 对于服务器端验证--hibernate validation 注解验证结果
	 */
	public final static String VALID_RESULT = "false";
}
