package com.cmcc.know.dao;

import com.cmcc.know.entity.KnowType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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
     * @param typeName 类型名称
     * @return KnowType
     * @Description: TODO 根据类型名称查询
     * @author zengzhibin
     * @date 2019年3月4日
     */
    KnowType selectByTypeName(@Param("typeName") String typeName);
}