package com.zhb.cloud.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

@Service
public class RedisService {

	// 当容器里有，就注入，否则就忽略
	@Autowired(required = false)
	private ShardedJedisPool shardedJedisPool;

	/**
	 * 插入数据
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public String set(final String key, final String value) {
		return execute(new Function<String, ShardedJedis>() {

			@Override
			public String callback(ShardedJedis shardedJedis) {
				// 具体的业务逻辑
				return shardedJedis.set(key, value);
			}
		});
	}

	/**
	 * 根据key查询数据
	 * 
	 * @param key
	 * @return
	 */
	public String get(final String key) {
		return execute(new Function<String, ShardedJedis>() {
			@Override
			public String callback(ShardedJedis shardedJedis) {
				// 具体的业务逻辑
				return shardedJedis.get(key);
			}
		});
	}

	/**
	 * 根据key删除
	 * 
	 * @param key
	 * @return
	 */
	public Long delete(final String key) {
		return execute(new Function<Long, ShardedJedis>() {

			@Override
			public Long callback(ShardedJedis shardedJedis) {
				// 具体的业务逻辑
				return shardedJedis.del(key);
			}
		});
	}

	/**
	 * 修改redis中数据的存活时间
	 * 
	 * @param key
	 * @param seconds
	 * @return
	 */
	public Long expire(final String key, final Integer seconds) {
		return execute(new Function<Long, ShardedJedis>() {

			@Override
			public Long callback(ShardedJedis shardedJedis) {
				// 具体的业务逻辑
				// 设置存活时间
				return shardedJedis.expire(key, seconds);
			}
		});
	}

	/**
	 * 新增并设置存活时间
	 * 
	 * @param key
	 * @param seconds
	 * @return
	 */
	public Long set(final String key, final String value, final Integer seconds) {
		return execute(new Function<Long, ShardedJedis>() {

			@Override
			public Long callback(ShardedJedis shardedJedis) {
				// 具体的业务逻辑
				// 保存数据
				shardedJedis.set(key, value);
				// 设置存活时间
				return shardedJedis.expire(key, seconds);
			}
		});
	}

	private <T> T execute(Function<T, ShardedJedis> fun) {
		ShardedJedis shardedJedis = null;
		try {
			// 从集群连接池中获取到jedis分片对象
			shardedJedis = shardedJedisPool.getResource();

			// 具体的业务逻辑
			return fun.callback(shardedJedis);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != shardedJedis) {
				// 关闭，检测连接是否有效，有效则放回到连接池中，无效则重置状态
				shardedJedis.close();
			}
		}
		return null;
	}
}