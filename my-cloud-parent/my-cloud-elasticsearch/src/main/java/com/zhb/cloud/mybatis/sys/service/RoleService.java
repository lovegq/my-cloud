package com.zhb.cloud.mybatis.sys.service;

import com.zhb.cloud.base.service.BaseService;
import com.zhb.cloud.mybatis.sys.model.Role;

/**
 * @Title: RoleService.java
 * @Package com.zhb.mybatis.sys.service
 * @Description: 
 * @author zhb
 * @date 2016年8月3日 下午3:27:54
 * @version V1.0
 */
public interface RoleService extends BaseService<Role> {

	/**
	 * @Title: updateModel
	 * @Description: TODO(用一句话描述该文件做什么)
	 * @param role
	 * @param privilegeId
	 * @return: void
	 * @author: zhb
	 * @throws 2016年8月3日下午4:45:44
	 */
	void updateModel(Role role, String privilegeId);

	/**
	 * @Title: saveModel
	 * @Description: TODO(用一句话描述该文件做什么)
	 * @param role
	 * @param privilegeId
	 * @return: void
	 * @author: zhb
	 * @throws 2016年8月3日下午4:45:56
	 */
	void saveModel(Role role, String privilegeId);

}
