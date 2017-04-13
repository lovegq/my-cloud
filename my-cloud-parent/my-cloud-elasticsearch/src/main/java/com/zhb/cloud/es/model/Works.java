package com.zhb.cloud.es.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

/**
 * @Title: Works.java
 * @Package com.zhb.mongo.model
 * @Description: 作品表
 * @author zhb
 * @date 2016年6月2日 下午2:01:08
 * @version V1.0
 */
@Document(indexName = "zhb", type = "works", shards = 1, replicas = 0, refreshInterval = "-1")
public class Works implements Serializable {
	private static final long serialVersionUID = 4056747329126833390L;
	@Id
	private String id;
	@Field
	private String workTitle;
	@Field
	private String description;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getWorkTitle() {
		return workTitle;
	}

	public void setWorkTitle(String workTitle) {
		this.workTitle = workTitle;
	}
}
