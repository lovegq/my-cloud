package com.zhb.cloud.core.utils;

/**
 * @Title: JsonReturn.java
 * @Package com.tztd.sts.core.util
 * @Description:处理异步请求的返回
 * @author zhb
 * @date 2016年5月5日 下午6:01:49
 * @version V1.0
 */
public class JsonReturn {
	/**
	 * code
	 */
	private String retcode = RetCode.OK_CODE;
	/**
	 * 信息
	 */
	private Object retmsg = RetCode.OK_MSG;
	/**
	 * 响应数据
	 */
	private Object retdata = "";

	public String getRetcode() {
		return retcode;
	}

	public void setRetcode(String retcode) {
		this.retcode = retcode;
	}

	public Object getRetmsg() {
		return retmsg;
	}

	public void setRetmsg(Object retmsg) {
		this.retmsg = retmsg;
	}

	public Object getRetdata() {
		return retdata;
	}

	public void setRetdata(Object retdata) {
		this.retdata = retdata;
	}

}
