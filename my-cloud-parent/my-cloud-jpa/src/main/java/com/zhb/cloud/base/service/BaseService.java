package com.zhb.cloud.base.service;

import org.springframework.data.domain.Page;

public interface BaseService<T> {
	/**
	 * @Title: findById
	 * @Description: 根据主键ID查询
	 * @param id
	 * @return: T
	 * @author: zhb
	 * @throws 2016年4月28日下午4:37:54
	 */
	T findById(String id);

	/**
	 * @Title: save
	 * @Description: 添加操作
	 * @param t
	 * @return: void
	 * @author: zhb
	 * @throws 2016年4月28日下午4:38:58
	 */
	T saveModel(T model);

	/**
	 * @Title: update
	 * @Description: 更新操作
	 * @param t
	 * @return: void
	 * @author: zhb
	 * @throws 2016年4月28日下午4:39:12
	 */
	T updateModel(T model);

	/**
	 * @Title: delete
	 * @Description:删除根据Id
	 * @param id
	 * @return: void
	 * @author: zhb
	 * @throws 2016年4月28日下午4:39:25
	 */
	void deleteModel(String id);

	/**
	 * @Title: totalAmount
	 * @Description:根据条件统计数量
	 * @return
	 * @return: int
	 * @author: zhb
	 * @throws 2016年6月12日上午9:27:30
	 */
	long totalAmount(T model, Object... objects);

	/**
	 * @Title: selectModelByCondition
	 * @Description:分页条件查询
	 * @param t
	 * @param pageRequest
	 * @return: Page<T>
	 * @author: zhb
	 * @throws 2016年6月15日下午1:30:40
	 */
	Page<T> selectModelByCondition(int pageNum, int pageSize, Object... objects);
}
