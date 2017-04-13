package com.zhb.cloud.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

/**
 * @Title: MongoConfig.java
 * @Package com.tztd.msg.config
 * @Description:
 * @author zhb
 * @date 2016年7月7日 下午7:02:51
 * @version V1.0
 */
@Configuration
public class ESConfig {
	public ElasticsearchTemplate elasticsearchTemplate() {
		return new ElasticsearchTemplate(null);
	}
}
