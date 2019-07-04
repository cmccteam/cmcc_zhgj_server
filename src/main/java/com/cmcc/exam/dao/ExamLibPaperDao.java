package com.cmcc.exam.dao;

import com.cmcc.exam.entity.ExamLibPaper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ExamLibPaperDao {
    int deleteByPrimaryKey(String id);

    int insert(ExamLibPaper record);

    int insertSelective(ExamLibPaper record);

    ExamLibPaper selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ExamLibPaper record);

    int updateByPrimaryKey(ExamLibPaper record);

    @Delete("DELETE FROM da_exam_lib_paper WHERE paper_id = #{paperId}")
    int deleteByPaperId(String paperId);
}