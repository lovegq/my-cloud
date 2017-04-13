package com.zhb.cloud.mybatis.sys.service.impl;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.zhb.cloud.mybatis.sys.model.Role;
import com.zhb.cloud.mybatis.sys.service.RoleService;

/**
 * @Title: UserServiceImpl.java
 * @Package com.zhb.mybatis.sys.service
 * @Description: 角色管理
 * @author zhb
 * @date 2016年8月3日 下午3:24:46
 * @version V1.0
 */
@Service
public class RoleServiceImpl implements RoleService {

	@Override
	public Role findById(String id) {
		return null;
	}

	@Override
	public int saveModel(Role model) {
		return 0;
	}

	@Override
	public void updateModel(Role model) {

	}

	@Override
	public void deleteModel(String id) {

	}

	@Override
	public long totalAmount(Role model, Object... objects) {
		return 0;
	}


	@Override
	public void updateModel(Role role, String privilegeId) {
		
	}

	@Override
	public void saveModel(Role role, String privilegeId) {
		
	}

	@Override
	public PageInfo<Role> selectModelByCondition(int pageNum, int pageSize) {
		return null;
	}

}
