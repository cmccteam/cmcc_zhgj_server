package com.cmcc.exam.dao;

import com.cmcc.exam.entity.ExamLibPaper;
import com.cmcc.exam.entity.ExamUser;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface ExamUserDao {
    int deleteByPrimaryKey(String id);

    int insert(ExamUser record);

    int insertSelective(ExamUser record);

    ExamUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ExamUser record);

    int updateByPrimaryKey(ExamUser record);

    /**
     * @return List<Map<String,String>>
     * @Description: TODO 考试积分排行榜
     * @author zengzhibin
     * @date 2019年3月1日
     */
    List<Map<String, String>> selectIntRank(@Param("rows") Integer rows);

    /**
     * @param userId  用户ID
     * @param paperId 试卷ID
     * @return List<Map<String,Object>>
     * @Description: TODO 获取user考试的所有题目
     * @author zengzhibin
     * @date 2019年3月4日
     */
    List<Map<String, Object>> selectMyPaperLibAll(@Param("userId") String userId, @Param("paperId") String paperId);

    /**
     * @param userId  用户ID
     * @param paperId 试卷ID
     * @return ExamUser
     * @Description: TODO 获取用户某试卷相关信息
     * @author zengzhibin
     * @date 2019年3月4日
     */
    ExamUser selectByPaperId(@Param("userId") String userId, @Param("paperId") String paperId);

    /**
     * @param userId  用户ID
     * @param paperId 试卷ID
     * @param index   做到第几题
     * @return Integer
     * @Description: TODO 更新用户试卷的题目数
     * @author zengzhibin
     * @date 2019年3月4日
     */
    Integer updateIndexByPaperId(ExamUser eu);

    /**
     * 获取试卷题目
     *
     * @param userId  用户ID
     * @param paperId 试卷ID
     * @return
     */
    List<ExamLibPaper> libPaper(@Param("userId") String userId, @Param("paperId") String paperId);

    /**
     * 获取试卷总分数
     *
     * @param userId  用户ID
     * @param paperId 试卷ID
     * @return
     */
    Integer totalScore(@Param("userId") String userId, @Param("paperId") String paperId);

    @Delete("DELETE FROM da_exam_user WHERE paper_id = #{paperId}")
    int deleteByPaperId(String paperId);
}