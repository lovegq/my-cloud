package com.zhb.cloud.es.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.zhb.cloud.es.model.Works;

/**
 * 
 * @Title: WorksRepository.java
 * @Package com.zhb.cloud.es.repository
 * @Description: 数据访问层
 * @author zhb
 * @date 2017年3月21日 上午11:13:33
 * @version V1.0
 */
public interface WorksRepository extends ElasticsearchRepository<Works, String> {
	Works findByWorkTitle(String workTitle);

}
