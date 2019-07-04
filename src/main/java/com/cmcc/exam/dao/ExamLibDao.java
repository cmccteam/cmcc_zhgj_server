package com.cmcc.exam.dao;

import com.cmcc.exam.entity.ExamLib;
import com.cmcc.exam.response.ExamLibPageResponse;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ExamLibDao {
    int deleteByPrimaryKey(String libId);

    int insert(ExamLib record);

    int insertSelective(ExamLib record);

    ExamLib selectByPrimaryKey(String libId);

    int updateByPrimaryKeySelective(ExamLib record);

    int updateByPrimaryKey(ExamLib record);

    /**
     * @return List<ExamLib>
     * @Description: TODO 随机生成题目从题库中
     * @author zengzhibin
     * @date 2019年3月1日
     */
    List<ExamLib> selectPaperLib(@Param("rows") Integer rows, @Param("typeId") String typeId);

    List<ExamLibPageResponse> getExamLibPage(@Param("libTitle") String libTitle, @Param("typeId") String typeId);

    @Delete("UPDATE da_exam_lib SET del_flag = '1' WHERE lib_id = #{libId}")
    int deleteExamLib(String libId);
}