package com.zhb.cloud.dic.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.zhb.cloud.core.utils.JsonReturn;
import com.zhb.cloud.core.utils.RetCode;
import com.zhb.cloud.dic.service.ProvinceService;
import com.zhb.cloud.jpa.controller.UserController;
import com.zhb.cloud.jpa.dic.model.Province;

@RestController
@RequestMapping("province")
public class ProvinceController {

	Logger log = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private ProvinceService provinceService;

	@RequestMapping("userInfo")
	public ModelAndView userInfo() {
		return new ModelAndView("shiro/user/userInfo");
	}

	@RequestMapping("userList")
	public JsonReturn userList(Integer pageNum, Integer pageSize) {
		JsonReturn jsonReturn = new JsonReturn();
		jsonReturn.setRetcode(RetCode.OK_CODE);
		jsonReturn.setRetmsg(RetCode.OK_MSG);
		jsonReturn.setRetdata(null);
		return jsonReturn;
	}

	@RequestMapping("insert")
	public JsonReturn insert() {
		JsonReturn jsonReturn = new JsonReturn();
		Province province = new Province();
		try {
			provinceService.saveModel(province);
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

	@RequestMapping("selectUserById")
	public JsonReturn selectUserById(String id) {
		JsonReturn jsonReturn = new JsonReturn();
		try {
			Province province = provinceService.findById(id);
			jsonReturn.setRetcode(RetCode.OK_CODE);
			jsonReturn.setRetdata(province);
			jsonReturn.setRetmsg("查询成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonReturn;
	}

	@RequestMapping("edit")
	public JsonReturn edit(Province province) {
		JsonReturn jsonReturn = new JsonReturn();
		Province target = provinceService.findById(province.getId());
		BeanUtils.copyProperties(province, target);
		try {
			provinceService.updateModel(target);
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
			provinceService.deleteModel(id);
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

}
