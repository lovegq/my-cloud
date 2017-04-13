package com.zhb.cloud.mybatis.sys.mapper;

import com.zhb.cloud.mybatis.sys.model.Privilege;

public interface PrivilegeMapper {
    int deleteByPrimaryKey(String id);

    int insert(Privilege record);

    int insertSelective(Privilege record);

    Privilege selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Privilege record);

    int updateByPrimaryKey(Privilege record);
}