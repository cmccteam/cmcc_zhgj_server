package com.cmcc.qualification.dao;

import java.util.List;
import java.util.Map;

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

	Page<Map<String,String>> selectPage(@Param("companyId")String companyId);

	List<Map<String, String>> selectUserList(ProCompanyUser proCompanyUser);

	List<Map<String, Object>> selectList(@Param("comqId")String comqId);
}