package com.zhb.cloud.mongo.repository;

import com.zhb.cloud.mongo.model.User;

public interface UserRepository {

	User findOne(String id);

	void save(User model);

}
