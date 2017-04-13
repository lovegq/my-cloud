package com.zhb.cloud.core.utils;

import java.io.IOException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
/**
 * @Title: BASE64Coding.java 
 * @Package com.tztd.sts.core.util 
 * @Description:base64加密工具类
 * @author zhb
 * @date 2016年5月5日 下午5:58:30 
 * @version V1.0
 */
@SuppressWarnings("all")
public class BASE64Coding {

	private static BASE64Encoder encoder = new sun.misc.BASE64Encoder();
	private static BASE64Decoder decoder = new sun.misc.BASE64Decoder();

	public BASE64Coding() {
	}

	public static String encode(String s) {
		return encoder.encode(s.getBytes());
	}

	public static String decode(String s) {
		try {
			byte[] temp = decoder.decodeBuffer(s);
			return new String(temp);
		} catch (IOException ioe) {
		}
		return s;
	}
}
