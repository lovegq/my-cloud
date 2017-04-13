package com.zhb.cloud.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import com.alibaba.druid.pool.DruidDataSource;
import com.zhb.cloud.core.datasource.DynamicDataSource;

/**
 * @Title: DataSouceConfig.java
 * @Package com.zhb.cloud.config
 * @Description:数据源配置
 * @author zhb
 * @date 2016年12月27日 下午4:31:49
 * @version V1.0
 */
@Configuration
public class DataSouceConfig {
	@Primary
	@ConfigurationProperties(prefix = "datasource.primary")
	public @Bean("master") DataSource primaryDataSource() {
		return DataSourceBuilder.create(DruidDataSource.class.getClassLoader()).build();
	}

	@ConfigurationProperties(prefix = "datasource.secondary")
	public @Bean("slave") DataSource secondaryDataSource() {
		return DataSourceBuilder.create(DruidDataSource.class.getClassLoader()).build();
	}

	/**
	 * @Title: getCurrentDataSource
	 * @Description:动态数据源
	 * @return
	 * @return: DataSource
	 * @author: zhb
	 * @throws 2016年12月27日下午4:32:14
	 */
	public @Bean DataSource getCurrentDataSource() {
		Map<Object, Object> targetDataSources = new HashMap<>();
		targetDataSources.put("master", primaryDataSource());
		targetDataSources.put("slave", secondaryDataSource());
		DynamicDataSource dataSource = new DynamicDataSource();
		dataSource.setTargetDataSources(targetDataSources);
		dataSource.setDefaultTargetDataSource(primaryDataSource());
		return dataSource;
	}
}
