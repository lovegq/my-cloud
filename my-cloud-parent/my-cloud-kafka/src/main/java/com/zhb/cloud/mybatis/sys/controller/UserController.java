package com.zhb.cloud.mybatis.sys.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.zhb.cloud.core.utils.BeanUtils;
import com.zhb.cloud.core.utils.EncryptionUtils;
import com.zhb.cloud.core.utils.JsonReturn;
import com.zhb.cloud.core.utils.RetCode;
import com.zhb.cloud.core.utils.ValidResult;
import com.zhb.cloud.mybatis.sys.model.User;
import com.zhb.cloud.mybatis.sys.service.UserService;

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
	@Autowired
	private DiscoveryClient client;

	@RequestMapping("userInfo")
	public ModelAndView userInfo() {
		return new ModelAndView("shiro/user/userInfo");
	}

	@RequestMapping("userList")
	public JsonReturn userList(Integer pageNum, Integer pageSize) {
		JsonReturn jsonReturn = new JsonReturn();
		ServiceInstance instance = client.getLocalServiceInstance();
		PageInfo<User> users = userService.selectModelByCondition(0, 3);
		log.info("/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + users);
		jsonReturn.setRetcode(RetCode.OK_CODE);
		jsonReturn.setRetmsg(RetCode.OK_MSG);
		jsonReturn.setRetdata(users);
		return jsonReturn;
	}

	@RequestMapping("insert")
	public JsonReturn insert(User user) {
		JsonReturn jsonReturn = new JsonReturn();
		user.setPassword(EncryptionUtils.getEncryptionPassword(user.getPassword()));
		try {
			userService.saveModel(user);
			log.info("用户保存成功!!!");
			jsonReturn.setRetcode(RetCode.OK_CODE);
			jsonReturn.setRetmsg("添加成功");
		} catch (Exception e) {
			jsonReturn.setRetcode(RetCode.ERROR_CODE);
			jsonReturn.setRetmsg("添加失败");
			log.info("用户保存成功!!!" + e.getMessage());
		}
		return jsonReturn;
	}

	@RequestMapping("checkPhone")
	public ValidResult checkPhone(String phone) {
		User user = userService.selectByPhone(phone);
		ValidResult result = new ValidResult();
		if (user != null) {
			log.info("用户查询成功!!!");
			result.setValid("false");
			return result;
		}
		result.setValid("true");
		return result;
	}

	@RequestMapping("selectUserById")
	public JsonReturn selectUserById(String id) {
		JsonReturn jsonReturn = new JsonReturn();
		try {
			User queryUser = userService.findById(id);
			jsonReturn.setRetcode(RetCode.OK_CODE);
			jsonReturn.setRetdata(queryUser);
			jsonReturn.setRetmsg("查询成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonReturn;
	}

	@RequestMapping("edit")
	public JsonReturn edit(User user) {
		JsonReturn jsonReturn = new JsonReturn();
		User target = userService.findById(user.getId());
		BeanUtils.copyProperties(user, target);
		try {
			userService.updateModel(target);
			log.info("用户更新成功!!!");
			jsonReturn.setRetcode(RetCode.OK_CODE);
			jsonReturn.setRetmsg("更新成功");
		} catch (Exception e) {
			log.info("用户更新失败!!!" + e.getMessage());
			jsonReturn.setRetcode(RetCode.ERROR_CODE);
			jsonReturn.setRetmsg("更新失败");
		}
		return jsonReturn;
	}

	@RequestMapping("delete")
	public JsonReturn delete(String id) {
		JsonReturn jsonReturn = new JsonReturn();
		try {
			userService.deleteModel(id);
			log.info("删除成功");
			jsonReturn.setRetcode(RetCode.OK_CODE);
			jsonReturn.setRetmsg("删除成功!");
		} catch (Exception e) {
			log.info("删除失败" + e.getMessage());
			jsonReturn.setRetcode(RetCode.ERROR_CODE);
			jsonReturn.setRetmsg("删除失败!");
			e.printStackTrace();
		}
		return jsonReturn;
	}

	/**
	 * 修改密码
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("updatePassword")
	public JsonReturn updatePassword(HttpServletRequest request, String password, String newPassword,
			String confirmPassword) {
		JsonReturn jsonReturn = new JsonReturn();
		String userName = (String) request.getSession().getAttribute("userName");
		String oldPassword = (String) request.getSession().getAttribute("password");
		if (!password.equals(oldPassword)) {
			jsonReturn.setRetcode(RetCode.ERROR_CODE);
			jsonReturn.setRetmsg("原始密码输入错误!");
			return jsonReturn;
		}
		if (!newPassword.equals(confirmPassword)) {
			jsonReturn.setRetcode(RetCode.ERROR_CODE);
			jsonReturn.setRetmsg("两次输入密码不一致!");
			return jsonReturn;
		}
		try {
			userService.updatePasswordByPhone(EncryptionUtils.getEncryptionPassword(newPassword), userName);
			log.info("修改密码成功");
			jsonReturn.setRetcode(RetCode.OK_CODE);
			jsonReturn.setRetmsg("修改密码成功!");
		} catch (Exception e) {
			log.info("修改密码失败" + e.getMessage());
			jsonReturn.setRetcode(RetCode.ERROR_CODE);
			jsonReturn.setRetmsg("修改 密码失败!");
			e.printStackTrace();
		}
		return jsonReturn;
	}
}
