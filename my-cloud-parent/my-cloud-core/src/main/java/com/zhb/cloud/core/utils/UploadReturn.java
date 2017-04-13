package com.zhb.cloud.core.utils;

/**
 * 
 * @Title: UploadReturn.java
 * @Package org.zhb.sys.core.util
 * @Description: error ,url,message
 * @author zhb
 * @date 2016年4月12日 下午4:16:34
 * @version V1.0
 */
public class UploadReturn {

	// 成功或者失败的状态 0--失败 1--成功
	private String code = "0";
	// url上传之后图片的路径
	private String uploadUrl = "";
	// 成功的信息
	private String message = "";
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getUploadUrl() {
		return uploadUrl;
	}

	public void setUploadUrl(String uploadUrl) {
		this.uploadUrl = uploadUrl;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
