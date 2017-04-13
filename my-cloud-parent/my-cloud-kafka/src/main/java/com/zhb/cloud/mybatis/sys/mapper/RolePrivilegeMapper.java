package com.zhb.cloud.mybatis.sys.mapper;

import com.zhb.cloud.mybatis.sys.model.RolePrivilege;

public interface RolePrivilegeMapper {
    int deleteByPrimaryKey(String id);

    int insert(RolePrivilege record);

    int insertSelective(RolePrivilege record);

    RolePrivilege selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(RolePrivilege record);

    int updateByPrimaryKey(RolePrivilege record);
}