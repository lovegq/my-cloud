package com.zhb.cloud.index.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("index")
public class IndexController {

	@RequestMapping("config")
	public String getConfig() {
		return "dfghjk";
	}

}
