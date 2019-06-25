package com.cmcc.exam.dao;

import com.cmcc.exam.entity.ExamPaper;
import com.cmcc.exam.response.ExamPaperPageResponse;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ExamPaperDao {
    int deleteByPrimaryKey(String paperId);

    int insert(ExamPaper record);

    int insertSelective(ExamPaper record);

    ExamPaper selectByPrimaryKey(String paperId);

    int updateByPrimaryKeySelective(ExamPaper record);

    int updateByPrimaryKey(ExamPaper record);

    /**
     * @param paperTitle
     * @return Page<ExamPaper>
     * @Description: TODO 分页查询试卷
     * @author zengzhibin
     * @date 2019年3月1日
     */
    Page<ExamPaper> selectPage(@Param("paperTitle") String paperTitle, @Param("userId") String userId);

    /**
     * @param paperTitle
     * @return Page<Map<String,Object>>
     * @Description: TODO 分页查询我的试卷
     * @author zengzhibin
     * @date 2019年3月1日
     */
    Page<ExamPaperPageResponse> selectMyPage(@Param("paperTitle") String paperTitle, @Param("userId") String userId, @Param("typeId") String typeId, @Param("status") String status);

    /**
     * @param paperId
     * @return Integer
     * @Description: TODO 根据ID删除未发布的试卷
     * @author zengzhibin
     * @date 2019年3月1日
     */
    Integer deleteSendPaper(String paperId);

}