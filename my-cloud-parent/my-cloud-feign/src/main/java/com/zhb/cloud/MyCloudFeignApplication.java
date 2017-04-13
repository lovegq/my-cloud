package com.zhb.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
/**
 * @Title: MyCloudFeignApplication.java 
 * @Package com.zhb.cloud 
 * @Description:  
 * @author zhb
 * @date 2016年12月13日 下午5:39:14 
 * @version V1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class MyCloudFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyCloudFeignApplication.class, args);
	}
}
