package com.zhb.cloud.core.utils;

/**
 * @Title: EncryptionUtils.java
 * @Package com.tztd.sts.core.util
 * @Description: 加密工具类
 * @author zhb
 * @date 2016年5月5日 下午5:59:31
 * @version V1.0
 */
public class EncryptionUtils {
	/**
	 * @Title: getEncryptionPassword
	 * @Description: 获取加密密码
	 * @param password
	 * @return: String
	 * @author: zhb
	 * @throws 2016年5月24日下午2:03:00
	 */
	public static String getEncryptionPassword(String password) {
		return new MD5().getMD5ofStr(BASE64Coding.encode(password));
	}
}
