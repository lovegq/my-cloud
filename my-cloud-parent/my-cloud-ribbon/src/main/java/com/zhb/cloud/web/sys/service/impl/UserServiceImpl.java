package com.zhb.cloud.web.sys.service.impl;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.github.pagehelper.PageInfo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zhb.cloud.core.utils.JsonReturn;
import com.zhb.cloud.core.utils.RetCode;
import com.zhb.cloud.web.sys.service.UserService;

/**
 * @Title: UserServiceImpl.java
 * @Package com.zhb.mybatis.sys.service
 * @Description: 用户管理
 * @author zhb
 * @date 2016年8月3日 下午3:24:46
 * @version V1.0
 */
@Service
@SuppressWarnings("all")
public class UserServiceImpl implements UserService {
	@Autowired
	RestTemplate restTemplate;
	final String SERVICE_NAME = "my-cloud-server";

	@HystrixCommand(fallbackMethod = "selectModelCallback")
	public JsonReturn selectModelByCondition(int pageNum, int pageSize) throws Exception {
		ResponseEntity<JsonReturn> forEntity = restTemplate.getForEntity(
				new URI("http://" + SERVICE_NAME + "/user/userList?pageNum=" + pageNum + "&pageSize=" + pageSize),
				JsonReturn.class);
		return forEntity.getBody();
	}

	public JsonReturn selectModelCallback(int pageNum, int pageSize) {
		JsonReturn jsonReturn = new JsonReturn();
		jsonReturn.setRetcode(RetCode.ERROR_CODE);
		jsonReturn.setRetdata("对不起,服务无法调用");
		jsonReturn.setRetmsg("对不起,服务无法调用");
		return jsonReturn;
	}

}
