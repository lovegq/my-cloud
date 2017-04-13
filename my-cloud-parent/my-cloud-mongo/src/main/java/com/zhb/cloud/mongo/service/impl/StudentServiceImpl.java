package com.zhb.cloud.mongo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.zhb.cloud.mongo.model.Student;
import com.zhb.cloud.mongo.repository.StudentRepository;
import com.zhb.cloud.mongo.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student findById(String id) {
		return studentRepository.findOne(id);
	}

	@Override
	public void saveModel(Student model) {
		 studentRepository.save(model);
	}

	@Override
	public void updateModel(Student model) {
	}

	@Override
	public void deleteModel(String id) {

	}

	@Override
	public long totalAmount(Student model, Object... objects) {
		return 0;
	}

	@Override
	public Page<Student> selectModelByCondition(int pageNum, int pageSize, Object... objects) {
		return null;
	}

}
