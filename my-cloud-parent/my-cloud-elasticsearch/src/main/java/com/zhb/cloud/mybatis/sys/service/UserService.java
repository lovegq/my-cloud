package com.zhb.cloud.mybatis.sys.service;

import com.zhb.cloud.base.service.BaseService;
import com.zhb.cloud.mybatis.sys.model.User;

/**
 * @Title: UserService.java
 * @Package com.zhb.mybatis.sys.service
 * @Description: 
 * @author zhb
 * @date 2016年8月3日 下午3:24:24
 * @version V1.0
 */
public interface UserService extends BaseService<User> {
	/**
	 * @Title: selectByPhone
	 * @Description: 根据电话号码查询
	 * @param phone
	 * @return
	 * @return: User
	 * @author: zhb
	 * @throws 2016年8月3日下午4:44:27
	 */
	User selectByPhone(String phone);

	/**
	 * @Title: updatePasswordByPhone
	 * @Description: 更新密码
	 * @param encryptionPassword
	 * @param userName
	 * @return: void
	 * @author: zhb
	 * @throws 2016年8月3日下午4:44:47
	 */
	void updatePasswordByPhone(String encryptionPassword, String userName);

	/**
	 * @Title: findUserByUserName
	 * @Description: 根据用户名查询用户
	 * @param username
	 * @return
	 * @return: UsernamePasswordToken
	 * @author: zhb
	 * @throws 2016年10月18日下午2:09:12
	 */
	User findByUserName(String username);

}
