package com.zhb.cloud.jpa.dic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "s_province")
public class Province {
	@Getter
	@Setter
	@Id
	@Column(unique = true, nullable = false, length = 32)
	private String id;
	@Getter
	@Setter
	@Column(unique = true, nullable = false, length = 30)
	private String name;
	@Getter
	@Setter
	@Column(unique = true, nullable = false, length = 30)
	private String code;

}
