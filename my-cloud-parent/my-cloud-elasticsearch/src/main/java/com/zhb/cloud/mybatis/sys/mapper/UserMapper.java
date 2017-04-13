package com.zhb.cloud.mybatis.sys.mapper;

import java.util.List;

import com.github.abel533.mapper.BaseMapper;
import com.zhb.cloud.mybatis.sys.model.User;

public interface UserMapper extends BaseMapper<User> {

	/**
	 * @Title: findByUserName
	 * @Description: 根据用户名查询
	 * @param username
	 * @return
	 * @return: User
	 * @author: zhb
	 * @throws 2016年10月18日下午2:12:06
	 */
	User findByUserName(String username);

	/**
	 * @Title: selectAll
	 * @Description: 查询所有
	 * @return
	 * @return: List<User>
	 * @author: zhb
	 * @throws 2016年10月18日下午3:25:57
	 */
	List<User> selectAll();
}