package com.cmcc.know.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cmcc.know.entity.KnowType;

@Mapper
public interface KnowTypeDao {
    int deleteByPrimaryKey(String typeId);

    int insert(KnowType record);

    int insertSelective(KnowType record);

    KnowType selectByPrimaryKey(String typeId);

    int updateByPrimaryKeySelective(KnowType record);

    int updateByPrimaryKey(KnowType record);

	List<KnowType> selectAll();

	/**
	 * 
	 * @Description: TODO 根据类型名称查询 
	 * @param typeName 类型名称
	 * @return KnowType  
	 * @author zengzhibin
	 * @date 2019年3月4日
	 */
	KnowType selectByTypeName(@Param("typeName") String typeName);
}