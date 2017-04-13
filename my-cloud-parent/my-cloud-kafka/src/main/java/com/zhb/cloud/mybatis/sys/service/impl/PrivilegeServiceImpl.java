package com.zhb.cloud.mybatis.sys.service.impl;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.zhb.cloud.mybatis.sys.model.Privilege;
import com.zhb.cloud.mybatis.sys.service.PrivilegeService;

/**
 * @Title: PrivilegeServiceImpl.java
 * @Package com.zhb.mybatis.sys.service.impl
 * @Description: 权限管理
 * @author zhb
 * @date 2016年8月3日 下午3:28:46
 * @version V1.0
 */
@Service
public class PrivilegeServiceImpl implements PrivilegeService {

	@Override
	public Privilege findById(String id) {
		return null;
	}

	@Override
	public int saveModel(Privilege model) {
		return 0;
	}

	@Override
	public void updateModel(Privilege model) {

	}

	@Override
	public void deleteModel(String id) {

	}

	@Override
	public long totalAmount(Privilege model, Object... objects) {
		return 0;
	}

	@Override
	public PageInfo<Privilege> selectModelByCondition(int pageNum, int pageSize) {
		return null;
	}

}
