package com.zhb.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;

@SpringBootApplication
@EnableZipkinStreamServer
@EnableDiscoveryClient
public class MyCloudSleuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyCloudSleuthApplication.class, args);
	}
}
