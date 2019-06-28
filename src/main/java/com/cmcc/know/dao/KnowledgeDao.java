package com.cmcc.know.dao;

import com.cmcc.know.entity.Knowledge;
import com.cmcc.know.entity.KnowledgeVo;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

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

	Page<KnowledgeVo> selectMyPage(KnowledgeVo hnowledge);
}