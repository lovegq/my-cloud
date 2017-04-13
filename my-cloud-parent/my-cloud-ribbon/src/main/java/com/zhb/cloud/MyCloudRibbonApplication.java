package com.zhb.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Title: MyCloudRibbonApplication.java
 * @Package com.zhb.cloud
 * @Description: ribbon 开启服务发现 ,负载均衡 ,断路器
 * @author zhb
 * @date 2016年11月17日 下午2:25:18
 * @version V1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
public class MyCloudRibbonApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyCloudRibbonApplication.class, args);
	}
}
