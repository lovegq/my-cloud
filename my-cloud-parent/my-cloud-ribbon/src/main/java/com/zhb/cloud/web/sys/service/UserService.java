package com.zhb.cloud.web.sys.service;

import com.zhb.cloud.core.utils.JsonReturn;

/**
 * @Title: UserService.java
 * @Package com.zhb.mybatis.sys.service
 * @Description:
 * @author zhb
 * @date 2016年8月3日 下午3:24:24
 * @version V1.0
 */
public interface UserService {
	/**
	 * @Title: selectModelByCondition
	 * @Description:
	 * @param i
	 * @param j
	 * @param user
	 * @return
	 * @return: PageInfo<User>
	 * @author: zhb
	 * @throws Exception
	 * @throws 2016年10月31日下午4:11:09
	 */
	JsonReturn selectModelByCondition(int pageNum, int pageSize) throws Exception;
}
