package com.zhb.cloud.jpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.zhb.cloud.jpa.model.User;
import com.zhb.cloud.jpa.repository.UserRepository;
import com.zhb.cloud.jpa.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public User findById(String id) {
		return null;
	}

	@Override
	public User saveModel(User model) {
		return userRepository.save(model);
	}

	@Override
	public User updateModel(User model) {
		return userRepository.save(model);
	}

	@Override
	public void deleteModel(String id) {

	}

	@Override
	public long totalAmount(User model, Object... objects) {
		return 0;
	}

	@Override
	public Page<User> selectModelByCondition(int pageNum, int pageSize, Object... objects) {
		return null;
	}

}
