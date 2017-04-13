package com.zhb.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MyCloudEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyCloudEurekaServerApplication.class, args);
	}
}
