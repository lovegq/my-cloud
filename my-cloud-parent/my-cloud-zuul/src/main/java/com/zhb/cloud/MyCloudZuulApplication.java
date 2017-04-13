package com.zhb.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringCloudApplication
@EnableZuulProxy
public class MyCloudZuulApplication {
	public static void main(String[] args) {
		SpringApplication.run(MyCloudZuulApplication.class, args);
	}
}
