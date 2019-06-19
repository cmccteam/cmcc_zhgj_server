package com.cmcc.know.dao;

import org.apache.ibatis.annotations.Mapper;

import com.cmcc.know.entity.Knowledge;
import com.github.pagehelper.Page;

/**
 * 
 * ClassName: KnowledgeDao 
 * @Description: TODO 资料库DAO
 * @author zengzhibin
 * @date 2019年2月27日
 */
@Mapper
public interface KnowledgeDao {
	
    int deleteByPrimaryKey(String hnowId);

    int insert(Knowledge record);

    int insertSelective(Knowledge record);

    Knowledge selectByPrimaryKey(String hnowId);

    int updateByPrimaryKeySelective(Knowledge record);

    int updateByPrimaryKeyWithBLOBs(Knowledge record);

    int updateByPrimaryKey(Knowledge record);

	Page<Knowledge> selectPage(Knowledge record);
}