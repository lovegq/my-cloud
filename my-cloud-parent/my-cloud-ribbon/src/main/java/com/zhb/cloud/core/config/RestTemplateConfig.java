package com.zhb.cloud.core.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
	/**
	 * @Title: restTemplate
	 * @Description:使用负载均衡
	 * @return: RestTemplate
	 * @author: zhb
	 * @throws 2016年11月17日下午2:42:23
	 */
	@LoadBalanced
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
