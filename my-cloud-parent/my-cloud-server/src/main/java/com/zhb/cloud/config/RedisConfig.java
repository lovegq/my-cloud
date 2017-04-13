package com.zhb.cloud.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedisPool;

/**
 * @Title: RedisConfig.java
 * @Package com.zzh.sys.configuration
 * @Description: redis整合spring的核心配置
 * @author zhb
 * @date 2016年3月6日 下午8:03:19
 * @version V1.0
 */
@Configuration
@EnableRedisHttpSession // 开启redis对httpsession的支持
public class RedisConfig {
	/**
	 * @Title: redisTemplate
	 * @Description: 操作模板
	 * @return: RedisTemplate<Object,Object>
	 * @param: @return
	 * @author: zhb
	 * @throws 2016年3月6日下午8:11:33
	 */
	@Autowired
	JedisConnectionFactory jedisConnectionFactory;

	/**
	 * @Title: redisTemplate
	 * @Description:获取操作的模板对象
	 * @return
	 * @return: RedisTemplate<Object,Object>
	 * @author: zhb
	 * @throws 2016年12月29日上午11:04:37
	 */
	public @Bean RedisTemplate<Object, Object> redisTemplate() {
		RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory);
		return redisTemplate;
	}

	/**
	 * @Title: getRedisConnection
	 * @Description: 获得链接
	 * @return
	 * @return: RedisConnection
	 * @author: zhb
	 * @throws 2016年12月29日上午11:04:32
	 */
	@Bean(name = "redisConnection")
	public RedisConnection getRedisConnection() {
		return jedisConnectionFactory.getConnection();
	}

	/**
	 * @Title: shardedJedisPool
	 * @Description: 获得分片池
	 * @return: ShardedJedisPool
	 * @author: zhb
	 * @throws 2016年12月29日上午11:04:27
	 */
	@Bean(name = "shardedJedisPool")
	public ShardedJedisPool shardedJedisPool() {
		JedisShardInfo shardInfo = jedisConnectionFactory.getShardInfo();
		List<JedisShardInfo> shards = new ArrayList<>();
		shards.add(shardInfo);
		return new ShardedJedisPool(jedisConnectionFactory.getPoolConfig(), shards);
	}

}
