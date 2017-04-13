package com.zhb.cloud.mongo.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.Setter;
@Document(collection = "t_role")
public class Role {
	@Id
	@Getter
	@Setter
	private String id;

	@Field("role_code")
	@Getter
	@Setter
	private String roleCode;
	@Field("role_name")
	@Getter
	@Setter
	private String roleName;
	@Field("create_date")
	@Getter
	@Setter
	private Date createDate;
	@Getter
	@Setter
	private String description;

}