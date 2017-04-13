package com.zhb.cloud.mongo.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.Setter;
@Document(collection = "t_privilege")
public class Privilege {
	@Id
	@Getter
	@Setter
	private String id;
	@Getter
	@Setter
	private String description;
	@Getter
	@Setter
	@Field("privilege_code")
	private String privilegeCode;
	@Getter
	@Setter
	@Field("privilege_name")
	private String privilegeName;
	@Getter
	@Setter
	@Field("create_date")
	private Date createDate;
}