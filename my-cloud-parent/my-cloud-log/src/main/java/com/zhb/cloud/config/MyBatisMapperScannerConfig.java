package com.zhb.cloud.config;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Title: MyBatisMapperScannerConfig.java
 * @Package com.zhb.mybatis.config
 * @Description: 注意，由于MapperScannerConfigurer执行的比较早，所以必须有下面的注解
 * @author zhb
 * @date 2016年8月3日 下午4:37:35
 * @version V1.0
 */
@Configuration
@AutoConfigureAfter(MyBatisConfig.class)
public class MyBatisMapperScannerConfig {
	@Bean
	public MapperScannerConfigurer mapperScannerConfigurer() {
		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
		mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
		mapperScannerConfigurer.setBasePackage("com.zhb.cloud.mybatis.sys.mapper");
		return mapperScannerConfigurer;
	}

}