package com.zhb.cloud.mybatis.sys.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.zhb.cloud.core.utils.JsonReturn;
import com.zhb.cloud.core.utils.RetCode;
import com.zhb.cloud.mybatis.sys.model.Privilege;
import com.zhb.cloud.mybatis.sys.service.PrivilegeService;

/**
 * @Title: PrivilegeController.java
 * @Package com.zhb.solr.jpa.sys.controller
 * @Description: 权限管理
 * @author zhb
 * @date 2016年6月28日 下午4:25:34
 * @version V1.0
 */
@RestController
@RequestMapping("/privilege/")
public class PrivilegeController {
	@Autowired
	private PrivilegeService privilegeService;
	Logger log = LoggerFactory.getLogger(PrivilegeController.class);

	@RequestMapping("privilegeInfo")
	public ModelAndView roleInfo() {
		return new ModelAndView("shiro/privilege/privilegeInfo");
	}

	@RequestMapping("privilegeList")
	public JsonReturn privilegeList(Privilege privilege) {
		JsonReturn jsonReturn = new JsonReturn();
		PageInfo<Privilege> page = privilegeService.selectModelByCondition(0,3);
		jsonReturn.setRetmsg("查询成功");
		jsonReturn.setRetdata(page);
		jsonReturn.setRetcode(RetCode.OK_CODE);
		return jsonReturn;
	}

	@RequestMapping("insert")
	public JsonReturn insert(Privilege privilege) {
		JsonReturn jsonReturn = new JsonReturn();
		try {
			privilegeService.saveModel(privilege);
			log.info("保存成功!!!");
			jsonReturn.setRetcode(RetCode.OK_CODE);
			jsonReturn.setRetmsg("添加成功");
		} catch (Exception e) {
			jsonReturn.setRetcode(RetCode.ERROR_CODE);
			jsonReturn.setRetmsg("添加失败");
			log.info("保存成功!!!" + e.getMessage());
		}
		return jsonReturn;
	}

	@RequestMapping("selectFunctionById")
	public JsonReturn selectFunctionById(String id, HttpServletRequest request) {
		JsonReturn jsonReturn = new JsonReturn();
		try {
			Privilege privilege = privilegeService.findById(id);
			jsonReturn.setRetcode(RetCode.OK_CODE);
			jsonReturn.setRetdata(privilege);
			jsonReturn.setRetmsg("查询成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonReturn;
	}

	@RequestMapping("edit")
	public JsonReturn edit(Privilege privilege) {
		JsonReturn jsonReturn = new JsonReturn();
		try {
			privilegeService.updateModel(privilege);
			log.info("更新成功!!!");
			jsonReturn.setRetcode(RetCode.OK_CODE);
			jsonReturn.setRetmsg("更新成功");
		} catch (Exception e) {
			log.info("更新失败!!!" + e.getMessage());
			jsonReturn.setRetcode(RetCode.ERROR_CODE);
			jsonReturn.setRetmsg("更新失败");
		}
		return jsonReturn;
	}

	@RequestMapping("delete")
	public JsonReturn delete(String id) {
		JsonReturn jsonReturn = new JsonReturn();
		try {
			privilegeService.deleteModel(id);
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