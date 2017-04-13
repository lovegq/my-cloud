package com.zhb.cloud.mongo.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.zhb.cloud.mongo.model.User;
import com.zhb.cloud.mongo.repository.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository {
	@Autowired
	@Qualifier(value = "primaryMongoTemplate")
	private MongoTemplate mongoTemplate;

	@Override
	public User findOne(String id) {
		return mongoTemplate.findById(id, User.class);
	}

	@Override
	public void save(User model) {
		mongoTemplate.save(model);
	}

}
