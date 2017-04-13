package com.zhb.cloud.dic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.zhb.cloud.dic.repository.ProvinceRepository;
import com.zhb.cloud.dic.service.ProvinceService;
import com.zhb.cloud.jpa.dic.model.Province;

@Service
public class ProvinceServiceImpl implements ProvinceService {
	@Autowired
	private ProvinceRepository provinceRepository;

	@Override
	public Province findById(String id) {
		return provinceRepository.findOne(id);
	}

	@Override
	public Province saveModel(Province model) {
		return provinceRepository.save(model);
	}

	@Override
	public Province updateModel(Province model) {
		return null;
	}

	@Override
	public void deleteModel(String id) {

	}

	@Override
	public long totalAmount(Province model, Object... objects) {
		return 0;
	}

	@Override
	public Page<Province> selectModelByCondition(int pageNum, int pageSize, Object... objects) {
		return null;
	}

}
