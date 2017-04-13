package com.zhb.cloud.mongo.repository;

import com.zhb.cloud.mongo.model.Student;

public interface StudentRepository {

	Student findOne(String id);

	void save(Student model);

}
