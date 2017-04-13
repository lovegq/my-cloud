package com.zhb.cloud.mongo.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.zhb.cloud.mongo.model.Student;
import com.zhb.cloud.mongo.repository.StudentRepository;

@Repository
public class StudentRepositoryImpl implements StudentRepository {
	@Autowired
	@Qualifier("seconderyMongoTemplate")
	private MongoTemplate mongoTemplate;

	@Override
	public Student findOne(String id) {
		return mongoTemplate.findById(id, Student.class);
	}

	@Override
	public void save(Student model) {
		mongoTemplate.save(model);
	}

}
