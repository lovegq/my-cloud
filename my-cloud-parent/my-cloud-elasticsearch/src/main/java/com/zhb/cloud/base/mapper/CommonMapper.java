package com.zhb.cloud.base.mapper;

import java.util.List;

/**
 * 
 * @author Administrator
 *
 * @param <T>
 */
public interface CommonMapper<T> {
	int deleteByPrimaryKey(String id);

	int insertSelective(T record);

	T selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(T record);

	List<T> selectAll();

}
