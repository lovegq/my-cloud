package com.zhb.cloud.mongo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.zhb.cloud.core.utils.BeanUtils;
import com.zhb.cloud.core.utils.EncryptionUtils;
import com.zhb.cloud.core.utils.JsonReturn;
import com.zhb.cloud.core.utils.RetCode;
import com.zhb.cloud.mongo.model.Student;
import com.zhb.cloud.mongo.service.StudentService;

@RestController
@RequestMapping("student")
public class StudentController {
	Logger log = LoggerFactory.getLogger(StudentController.class);
	@Autowired
	private StudentService studentService;

	@RequestMapping("studentInfo")
	public ModelAndView studentInfo() {
		return new ModelAndView("shiro/student/studentInfo");
	}

	@RequestMapping("studentList")
	public JsonReturn studentList(Integer pageNum, Integer pageSize) {
		JsonReturn jsonReturn = new JsonReturn();
		jsonReturn.setRetcode(RetCode.OK_CODE);
		jsonReturn.setRetmsg(RetCode.OK_MSG);
		jsonReturn.setRetdata(null);
		return jsonReturn;
	}

	@RequestMapping("insert")
	public JsonReturn insert() {
		JsonReturn jsonReturn = new JsonReturn();
		Student student = new Student();
		student.setAge(10);
		student.setGender(1);
		student.setName("张三");
		student.setPassword("123456");
		student.setPassword(EncryptionUtils.getEncryptionPassword(student.getPassword()));
		try {
			studentService.saveModel(student);
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

	@RequestMapping("selectstudentById")
	public JsonReturn selectstudentById(String id) {
		JsonReturn jsonReturn = new JsonReturn();
		try {
			Student student = studentService.findById(id);
			jsonReturn.setRetcode(RetCode.OK_CODE);
			jsonReturn.setRetdata(student);
			jsonReturn.setRetmsg("查询成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonReturn;
	}

	@RequestMapping("edit")
	public JsonReturn edit(Student student) {
		JsonReturn jsonReturn = new JsonReturn();
		Student target = studentService.findById(student.getId());
		BeanUtils.copyProperties(student, target);
		try {
			studentService.updateModel(target);
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
			studentService.deleteModel(id);
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
