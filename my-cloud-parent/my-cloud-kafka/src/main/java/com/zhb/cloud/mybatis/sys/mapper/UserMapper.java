package com.zhb.cloud.mybatis.sys.mapper;

import java.util.List;

import com.zhb.cloud.mybatis.sys.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(String id);

    int insertSelective(User record);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(User record);

	/**
	 * @Title: findByUserName 
	 * @Description: 根据用户名查询
	 * @param username
	 * @return
	 * @return: User
	 * @author: zhb
	 * @throws
	 * 2016年10月18日下午2:12:06
	 */
	User findByUserName(String username);

	/**
	 * @Title: selectAll 
	 * @Description: TODO(用一句话描述该文件做什么) 
	 * @return
	 * @return: List<User>
	 * @author: zhb
	 * @throws
	 * 2016年10月18日下午3:25:57
	 */
	List<User> selectAll();
}