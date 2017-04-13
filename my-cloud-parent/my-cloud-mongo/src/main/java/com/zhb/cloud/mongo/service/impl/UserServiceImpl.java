package com.zhb.cloud.mongo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.zhb.cloud.mongo.model.User;
import com.zhb.cloud.mongo.repository.UserRepository;
import com.zhb.cloud.mongo.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public User findById(String id) {
		return userRepository.findOne(id);
	}

	@Override
	public void saveModel(User model) {
		userRepository.save(model);
	}

	@Override
	public void updateModel(User model) {
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
