package com.zhb.cloud.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import com.alibaba.druid.pool.DruidDataSource;

@Configuration
public class DataSourceConfig {
	@ConfigurationProperties(prefix = "datasource.primary")
	@Primary
	@Bean(name = "primaryDataSource")
	public DataSource primaryDataSource() {
		return DataSourceBuilder.create(DruidDataSource.class.getClassLoader()).build();
	}

	@Bean(name = "secondaryDataSource")
	@ConfigurationProperties(prefix = "datasource.secondary")
	public DataSource secondaryDataSource() {
		return DataSourceBuilder.create(DruidDataSource.class.getClassLoader()).build();
	}
}