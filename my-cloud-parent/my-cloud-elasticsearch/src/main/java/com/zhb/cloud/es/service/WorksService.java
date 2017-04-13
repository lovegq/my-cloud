package com.zhb.cloud.es.service;

import com.zhb.cloud.base.service.BaseService;
import com.zhb.cloud.es.model.Works;

/**
 * @Title: WorksService.java
 * @Package com.zhb.cloud.es.service
 * @Description: 业务
 * @author zhb
 * @date 2017年3月21日 上午11:15:32
 * @version V1.0
 */
public interface WorksService extends BaseService<Works> {
	Works findByWorkTitle(String workTitle);
}
