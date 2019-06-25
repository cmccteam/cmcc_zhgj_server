package com.cmcc.qualification.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cmcc.qualification.entity.ProCompanyUser;
import com.github.pagehelper.Page;

@Mapper
public interface ProCompanyUserDao {
    int deleteByPrimaryKey(String cpUserId);

    int insert(ProCompanyUser record);

    int insertSelective(ProCompanyUser record);

    ProCompanyUser selectByPrimaryKey(String cpUserId);

    int updateByPrimaryKeySelective(ProCompanyUser record);

    int updateByPrimaryKey(ProCompanyUser record);

	Integer updateData(ProCompanyUser proCompanyUser);

	Integer deleteData(@Param("comqId")String comqId, @Param("userId")String userId);

	Page<ProCompanyUser> selectPage(@Param("companyId")String companyId);
}