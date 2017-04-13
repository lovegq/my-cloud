package com.zhb.cloud.mybatis.sys.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.zhb.cloud.core.utils.JsonReturn;
import com.zhb.cloud.core.utils.RetCode;
import com.zhb.cloud.mybatis.sys.model.Role;
import com.zhb.cloud.mybatis.sys.service.RoleService;

/**
 * @ClassName: Rolecontroller。
 * @Description: Role管理Controller
 * @author: zhb
 *
 */
@RestController
@RequestMapping("/role/")
public class RoleController {
	@Autowired
	private RoleService roleService;
	Logger log = LoggerFactory.getLogger(RoleController.class);

	@RequestMapping("roleInfo")
	public ModelAndView roleInfo() {
		return new ModelAndView("shiro/role/roleInfo");
	}

	@RequestMapping("roleList")
	public JsonReturn roleList(Role role) {
		JsonReturn jsonReturn = new JsonReturn();
		PageInfo<Role> page = roleService.selectModelByCondition(0, 3);
		jsonReturn.setRetcode(RetCode.OK_CODE);
		jsonReturn.setRetdata(page);
		jsonReturn.setRetmsg("查询成功");
		return jsonReturn;
	}

	@RequestMapping("insert")
	public JsonReturn insert(Role role, String privilegeId) {
		JsonReturn jsonReturn = new JsonReturn();
		try {
			roleService.saveModel(role, privilegeId);
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

	@RequestMapping("selectRoleById")
	public JsonReturn selectRoleById(String id) {
		JsonReturn jsonReturn = new JsonReturn();
		try {
			Role role = roleService.findById(id);
			jsonReturn.setRetcode(RetCode.OK_CODE);
			jsonReturn.setRetdata(role);
			jsonReturn.setRetmsg("查询成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonReturn;
	}

	@RequestMapping("edit")
	public JsonReturn edit(Role role, String privilegeId) {
		JsonReturn jsonReturn = new JsonReturn();
		try {
			roleService.updateModel(role, privilegeId);
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
			roleService.deleteModel(id);
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