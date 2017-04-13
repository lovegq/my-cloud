package com.zhb.cloud.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;

/**
 * @Title: DataSouceConfig.java
 * @Package com.zhb.cloud.config
 * @Description:数据源配置
 * @author zhb
 * @date 2016年12月27日 下午4:31:49
 * @version V1.0
 */
@Configuration
public class MongoConfig {
	Logger log = LoggerFactory.getLogger(MongoConfig.class);
	@Value("${mongo.primary.databaseName}")
	private String prmaryDatabaseName;

	@Value("${mongo.primary.host}")
	private String primaryHost;

	@Value("${mongo.primary.port}")
	private Integer primaryPort;

	@Value("${mongo.secondery.databaseName}")
	private String databaseName;
	@Value("${mongo.secondery.host}")
	private String host;
	@Value("${mongo.secondery.port}")
	private Integer port;

	@Primary
	public @Bean("primaryDbFactory") MongoDbFactory primaryMongoDbFactory() {
		MongoDbFactory dbFactory = new SimpleMongoDbFactory(new MongoClient(primaryHost, primaryPort),
				prmaryDatabaseName);
		log.info(dbFactory.getDb().toString());
		return dbFactory;
	}

	public @Bean("seconderyDbFactory") MongoDbFactory seconderyMongoDbFactory() {
		MongoDbFactory dbFactory = new SimpleMongoDbFactory(new MongoClient(host, port), databaseName);
		log.info(dbFactory.getDb().toString());
		return dbFactory;
	}

	@Primary
	public @Bean(name = "primaryMongoTemplate") MongoTemplate primaryMongoTemplate(
			@Qualifier("primaryDbFactory") MongoDbFactory mongoDbFactory) {
		return new MongoTemplate(mongoDbFactory);
	}

	public @Bean(name = "seconderyMongoTemplate") MongoTemplate seconderyMongoTemplate(
			@Qualifier("seconderyDbFactory") MongoDbFactory mongoDbFactory) {
		return new MongoTemplate(mongoDbFactory);
	}
}
