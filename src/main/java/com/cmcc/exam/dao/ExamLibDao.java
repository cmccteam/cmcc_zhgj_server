package com.cmcc.exam.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cmcc.exam.entity.ExamLib;
@Mapper
public interface ExamLibDao {
    int deleteByPrimaryKey(String libId);

    int insert(ExamLib record);

    int insertSelective(ExamLib record);

    ExamLib selectByPrimaryKey(String libId);

    int updateByPrimaryKeySelective(ExamLib record);

    int updateByPrimaryKey(ExamLib record);
    
    /**
     * 
     * @Description: TODO 随机生成题目从题库中
     * @return List<ExamLib>  
     * @author zengzhibin
     * @date 2019年3月1日
     */
	List<ExamLib> selectPaperLib(@Param("rows") Integer rows);
}