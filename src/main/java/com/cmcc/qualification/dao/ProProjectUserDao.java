package com.cmcc.qualification.dao;

import org.apache.ibatis.annotations.Mapper;

import com.cmcc.qualification.entity.ProProjectUser;

@Mapper
public interface ProProjectUserDao {
    int deleteByPrimaryKey(String id);

    int insert(ProProjectUser record);

    int insertSelective(ProProjectUser record);

    ProProjectUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ProProjectUser record);

    int updateByPrimaryKey(ProProjectUser record);

    /**
     * 根据用户id更新人员信息
     * @param proProjectUser
     * @return
     */
	Integer updateByUserId(ProProjectUser proProjectUser);
}