package com.cmcc.exam.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cmcc.exam.entity.ExamLibUser;
@Mapper
public interface ExamLibUserDao {
    int deleteByPrimaryKey(String id);

    int insert(ExamLibUser record);

    int insertSelective(ExamLibUser record);

    ExamLibUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ExamLibUser record);

    int updateByPrimaryKey(ExamLibUser record);

    
    /**
     * 
     * @Description: TODO 获取用户做的某题目结果详情
     * @param userId
     * @param libPaperId
     * @return ExamLibUser  
     * @author zengzhibin
     * @date 2019年3月4日
     */
	ExamLibUser selectBylibUserId(@Param("userId") String userId, @Param("libPaperId") String libPaperId);

	/**
	 * 
	 * @Description: TODO 获取用户试卷的总分数与积分
	 * @param userId
	 * @param paperId
	 * @return Map<String,Object>  
	 * @author zengzhibin
	 * @date 2019年3月5日
	 */
	Map<String, Object> selectMyPaperScore(@Param("userId") String userId, @Param("libPaperId") String paperId);
}