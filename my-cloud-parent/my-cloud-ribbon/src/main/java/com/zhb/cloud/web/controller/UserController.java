package com.zhb.cloud.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.zhb.cloud.core.utils.JsonReturn;
import com.zhb.cloud.web.sys.service.UserService;

/**
 * @ClassName: Usercontroller。
 * @Description: User管理Controller
 * @author: zhb
 *
 */
@RestController
@RequestMapping("/user/")
public class UserController {
	Logger log = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserService userService;

	@RequestMapping("userInfo")
	public ModelAndView userInfo() {
		return new ModelAndView("shiro/user/userInfo");
	}

	@RequestMapping("userList")
	public JsonReturn userList() throws Exception {
		JsonReturn jsonReturn = userService.selectModelByCondition(0, 3);
		return jsonReturn;
	}
}
