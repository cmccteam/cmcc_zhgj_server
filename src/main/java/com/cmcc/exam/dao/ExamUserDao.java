package com.cmcc.exam.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cmcc.exam.entity.ExamPaper;
import com.cmcc.exam.entity.ExamUser;
import com.cmcc.know.entity.Knowledge;
import com.github.pagehelper.Page;
@Mapper
public interface ExamUserDao {
    int deleteByPrimaryKey(String id);

    int insert(ExamUser record);

    int insertSelective(ExamUser record);

    ExamUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ExamUser record);

    int updateByPrimaryKey(ExamUser record);

    /**
     * 
     * @Description: TODO 考试积分排行榜
     * @return List<Map<String,String>>  
     * @author zengzhibin
     * @date 2019年3月1日
     */
	List<Map<String, String>> selectIntRank(@Param("rows") Integer rows);

	/**
	 * 
	 * @Description: TODO 获取user考试的所有题目
	 * @param userId 用户ID 
	 * @param paperId 试卷ID
	 * @return List<Map<String,Object>>  
	 * @author zengzhibin
	 * @date 2019年3月4日
	 */
	List<Map<String, Object>> selectMyPaperLibAll(@Param("userId") String userId, @Param("paperId") String paperId);

	/**
	 * 
	 * @Description: TODO 获取用户某试卷相关信息
	 * @param userId 用户ID
	 * @param paperId 试卷ID
	 * @return ExamUser  
	 * @author zengzhibin
	 * @date 2019年3月4日
	 */
	ExamUser selectByPaperId(@Param("userId") String userId, @Param("paperId") String paperId);

	/**
	 * 
	 * @Description: TODO 更新用户试卷的题目数
	 * @param userId 用户ID
	 * @param paperId 试卷ID
	 * @param index 做到第几题
	 * @return Integer  
	 * @author zengzhibin
	 * @date 2019年3月4日
	 */
	Integer updateIndexByPaperId(ExamUser eu);
	
}