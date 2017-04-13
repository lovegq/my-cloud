package com.zhb.cloud.mybatis.sys.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhb.cloud.core.utils.UUIDUtil;
import com.zhb.cloud.mybatis.sys.mapper.UserMapper;
import com.zhb.cloud.mybatis.sys.model.User;
import com.zhb.cloud.mybatis.sys.service.UserService;

/**
 * @Title: UserServiceImpl.java
 * @Package com.zhb.mybatis.sys.service
 * @Description: 用户管理
 * @author zhb
 * @date 2016年8月3日 下午3:24:46
 * @version V1.0
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;

	@Override
	public User findByUserName(String username) {
		return userMapper.findByUserName(username);
	}

	@Override
	public User findById(String id) {
		return null;
	}

	@Override
	public int saveModel(User model) {
		model.setId(UUIDUtil.getId());
		return userMapper.insertSelective(model);
	}

	@Override
	public void updateModel(User model) {
		userMapper.updateByPrimaryKeySelective(model);
	}

	@Override
	public void deleteModel(String id) {

	}

	@Override
	public long totalAmount(User model, Object... objects) {
		return 0;
	}

	@Override
	public User selectByPhone(String phone) {
		return null;
	}

	@Override
	public void updatePasswordByPhone(String encryptionPassword, String userName) {

	}

	@Override
	public PageInfo<User> selectModelByCondition(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<User> list = userMapper.selectAll();
		PageInfo<User> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}
}
