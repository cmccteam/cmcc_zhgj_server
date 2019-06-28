package com.cmcc.qualification.dao;

import org.apache.ibatis.annotations.Mapper;

import com.cmcc.qualification.entity.DaKnowledgeUser;

@Mapper
public interface DaKnowledgeUserDao {
	
    int deleteByPrimaryKey(String id);

    int insert(DaKnowledgeUser record);

    int insertSelective(DaKnowledgeUser record);

    DaKnowledgeUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DaKnowledgeUser record);

    int updateByPrimaryKey(DaKnowledgeUser record);

	Integer updateToconsult(DaKnowledgeUser record);
}