package com.cmcc.exam.dao;

import org.apache.ibatis.annotations.Mapper;

import com.cmcc.exam.entity.ExamLibPaper;
@Mapper
public interface ExamLibPaperDao {
    int deleteByPrimaryKey(String id);

    int insert(ExamLibPaper record);

    int insertSelective(ExamLibPaper record);

    ExamLibPaper selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ExamLibPaper record);

    int updateByPrimaryKey(ExamLibPaper record);
}