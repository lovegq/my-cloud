package com.zhb.cloud.mongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
@Document(collection = "t_student")
public class Student {
	@Id
	@Setter
	@Getter
	private String id;
	@Setter
	@Getter
	private String name;
	@Setter
	@Getter
	private String password;
	@Setter
	@Getter
	private Integer age;
	@Setter
	@Getter
	private Integer gender;

}
