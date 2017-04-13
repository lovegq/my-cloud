package com.zhb.cloud.es.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.zhb.cloud.es.model.Works;
import com.zhb.cloud.es.repository.WorksRepository;
import com.zhb.cloud.es.service.WorksService;

@Service
public class WorksServiceImpl implements WorksService {
	@Autowired
	private WorksRepository worksRepository;

	@Override
	public Works findById(String id) {
		return null;
	}

	@Override
	public int saveModel(Works model) {
		return 0;
	}

	@Override
	public void updateModel(Works model) {

	}

	@Override
	public void deleteModel(String id) {

	}

	@Override
	public long totalAmount(Works model, Object... objects) {
		return 0;
	}

	@Override
	public PageInfo<Works> selectModelByCondition(int pageNum, int pageSize) {
		return null;
	}

	public Works findByWorkTitle(String workTitle) {
		return worksRepository.findByWorkTitle(workTitle);
	}

}
