package com.cmcc.exam.service;


import com.cmcc.common.bean.BaseUser;
import com.cmcc.common.bean.Result;
import com.cmcc.exam.entity.ExamLibUser;
import com.cmcc.exam.entity.ExamPaper;
import com.cmcc.exam.request.SubmitPaperRequest;
import com.github.pagehelper.Page;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * ClassName: ExamMainService
 *
 * @author zengzhibin
 * @Description: TODO 知识竞赛业务接口
 * @date 2019年2月27日
 */
public interface ExamMainService {

    /**
     * @param pageNum  页码从1开始
     * @param pageSize 每页大小
     * @param orderBy  排序字段
     * @param title    条件查询对象
     * @return Page<ExamPaper>
     * @Description: TODO 带条件分页获取试卷数据
     * @author zengzhibin
     * @date 2019年2月27日
     */
    public Page<ExamPaper> getExamPaperPage(Integer pageNum, Integer pageSize, String orderBy, String title, String userId);

    /**
     * @param pageNum  页码从1开始
     * @param pageSize 每页大小
     * @param orderBy  排序字段
     * @param title    条件查询对象
     * @return Page<Map<String,Object>>
     * @Description: TODO 带条件分页获取我的试卷数据
     * @author zengzhibin
     * @date 2019年2月27日
     */
    Result getMyExamPaperPage(Integer pageNum, Integer pageSize, String orderBy, String title, String typeId, String status, BaseUser baseUser);

    /**
     * 添加试卷
     *
     * @param examPaper
     * @param baseUser
     * @return
     */
    Result add(ExamPaper examPaper, BaseUser baseUser);

    /**
     * 更新试卷
     *
     * @param examPaper
     * @return
     */
    Result update(ExamPaper examPaper, BaseUser baseUser);

    /**
     * @param paperId 试卷ID
     * @return Integer  1成功 0失败
     * @Description: TODO 删除试卷
     * @author zengzhibin
     * @date 2019年2月27日
     */
    public Integer delete(String paperId);

    /**
     * @param rows 排行榜展示数量
     * @return List<Map<String,String>>
     * @Description: TODO 获取积分排行榜
     * @author zengzhibin
     * @date 2019年3月1日
     */
    public List<Map<String, String>> getIntRank(Integer rows);

    /**
     * @param parperId 试卷ID
     * @return boolean
     * @Description: TODO 生成试卷题目
     * @author zengzhibin
     * @date 2019年3月1日
     */
    public boolean updateLibPaper(String parperId, Integer rows, String typeId);

    /**
     * @param userId
     * @param paperId
     * @return List<Map<String,Object>>
     * @Description: TODO 参与考试，获取未做题目
     * @author zengzhibin
     * @date 2019年3月1日
     */
    public Map<String, Object> takePart(String userId, String paperId, Integer tmType, Integer index, ExamLibUser examLibUser);

    /**
     * @param typeId 知识分类ID
     * @param file
     * @return Result
     * @Description: TODO 导入题目到库
     * @author zengzhibin
     * @date 2019年3月1日
     */
    Result importLib(String typeId, MultipartFile file, BaseUser baseUser);

    /**
     * 获取试卷题目
     *
     * @param paperId 试卷ID
     * @return
     */
    Result libPaper(String paperId, BaseUser baseUser);

    /**
     * 交卷
     *
     * @param submitPaperRequest 交卷请求参数
     * @return
     */
    Result submitPaper(SubmitPaperRequest submitPaperRequest, BaseUser baseUser);

    /**
     * 更新试卷状态
     *
     * @param paperId
     * @param status
     * @return
     */
    Result updatePaperStatus(String paperId, String status);
}
