package com.cmcc.exam.service.impl;

import com.cmcc.common.bean.BaseUser;
import com.cmcc.common.bean.Result;
import com.cmcc.common.bean.ResultCode;
import com.cmcc.common.utils.ExcelUtil;
import com.cmcc.common.utils.IdGenerateUtil;
import com.cmcc.common.utils.MathUtil;
import com.cmcc.exam.bean.ExamLibImportBean;
import com.cmcc.exam.dao.*;
import com.cmcc.exam.entity.*;
import com.cmcc.exam.request.SubmitPaperRequest;
import com.cmcc.exam.request.SubmitPaperResultRequest;
import com.cmcc.exam.response.ExamPaperPageResponse;
import com.cmcc.exam.service.ExamMainService;
import com.cmcc.know.dao.KnowTypeDao;
import com.cmcc.know.entity.KnowType;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

/**
 * ClassName: ExamMainServiceImpl
 *
 * @author zengzhibin
 * @Description: TODO 知识竞赛业务实现类
 * @date 2019年2月27日
 */
@Service
public class ExamMainServiceImpl implements ExamMainService {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * 试卷管理DAO
     */
    @Autowired
    private ExamPaperDao examPaperDao;

    /**
     * 参试人员DAO
     */
    @Autowired
    private ExamUserDao examUserDao;

    /**
     * 人员考试结果DAO
     */
    @Autowired
    private ExamLibUserDao examLibUserDao;

    /**
     * 题库DAO
     */
    @Autowired
    private ExamLibDao examLibDao;
    /**
     * 试卷题目DAO
     */
    @Autowired
    private ExamLibPaperDao examLibPaperDao;

    /**
     * 试卷题目DAO
     */
    @Autowired
    private KnowTypeDao knowTypeDao;

    @Override
    public Page<ExamPaper> getExamPaperPage(Integer pageNum, Integer pageSize, String orderBy, String title, String userId) {
        PageHelper.startPage(pageNum, pageSize, orderBy);
        return examPaperDao.selectPage(title, userId);
    }

    @Override
    public Result getMyExamPaperPage(Integer pageNum, Integer pageSize, String orderBy, String title, String typeId, String status, BaseUser baseUser) {
        if (baseUser == null || StringUtils.isBlank(baseUser.getUserId()))
            return Result.failure(ResultCode.USER_NOT_EXIST);
        PageHelper.startPage(pageNum, pageSize, orderBy);
        Page<ExamPaperPageResponse> page = examPaperDao.selectMyPage(title, baseUser.getUserId(), typeId, status);
        return Result.success(page.toPageInfo());
    }

    @Transactional
    @Override
    public Result add(ExamPaper examPaper, BaseUser baseUser) {
        if (baseUser == null || StringUtils.isBlank(baseUser.getUserId()))
            return Result.failure(ResultCode.USER_NOT_EXIST);
        examPaper.setPaperId(IdGenerateUtil.uuid3());
        examPaper.setCreateName(baseUser.getUserId());
        examPaper.setCreateTime(new Date());
        examPaper.setTotal(examPaper.getUserId().length);
        if (StringUtils.equals(examPaper.getStatus(), "0")) {//发布试卷
            examPaper.setSendTime(new Date());
        }
        this.updateLibPaper(examPaper.getPaperId(), examPaper.getRows(), examPaper.getTypeId());//生成题目
        for (String userId : examPaper.getUserId()) {//保存考试人员
            ExamUser examUser = new ExamUser();
            examUser.setId(IdGenerateUtil.uuid3());
            examUser.setPaperId(examPaper.getPaperId());
            examUser.setUserId(userId);
            examUser.setScore(0);
            examUser.setIntegral(0);
            examUser.setStatus(String.valueOf(0));
            examUser.setLibSort(0);
            examUserDao.insertSelective(examUser);
        }
        examPaperDao.insertSelective(examPaper);//保存试卷
        return Result.success();
    }

    @Transactional
    @Override
    public Result update(ExamPaper examPaper, BaseUser baseUser) {
        if (baseUser == null || StringUtils.isBlank(baseUser.getUserId()))
            return Result.failure(ResultCode.USER_NOT_EXIST);
        ExamPaper ep = examPaperDao.selectByPrimaryKey(examPaper.getPaperId());
        if (StringUtils.equals(ep.getStatus(), "0")) {
            return Result.success();
        } else {
            examPaper.setCreateName(baseUser.getUserId());
            examPaper.setCreateTime(new Date());
            examPaper.setTotal(examPaper.getUserId().length);
            if (StringUtils.equals(examPaper.getStatus(), "0")) {//发布试卷
                examPaper.setSendTime(new Date());
                this.updateLibPaper(examPaper.getPaperId(), examPaper.getRows(), examPaper.getTypeId());//生成题目
                for (String userId : examPaper.getUserId()) {//保存考试人员
                    ExamUser examUser = new ExamUser();
                    examUser.setId(IdGenerateUtil.uuid3());
                    examUser.setPaperId(examPaper.getPaperId());
                    examUser.setUserId(userId);
                    examUser.setStatus("1");
                    examUser.setLibSort(0);
                    examUserDao.insertSelective(examUser);
                }
            }
            examPaperDao.updateByPrimaryKeySelective(examPaper);//保存试卷
            return Result.success();
        }
    }

    @Transactional
    @Override
    public Integer delete(String paperId) {
        return examPaperDao.deleteSendPaper(paperId);
    }

    @Override
    public List<Map<String, String>> getIntRank(Integer rows) {
        return examUserDao.selectIntRank(rows);
    }

    @Transactional
    public boolean updateLibPaper(String paperId, Integer rows, String typeId) {
        //生成试卷题库从题库中
        List<ExamLib> libs = examLibDao.selectPaperLib(rows, typeId);
        for (int i = 0; i < libs.size(); i++) {
            ExamLib examLib = libs.get(i);
            ExamLibPaper examLibPaper = new ExamLibPaper();
            examLibPaper.setId(IdGenerateUtil.uuid3());
            examLibPaper.setLibId(examLib.getLibId());
            examLibPaper.setPaperId(paperId);
            examLibPaper.setLibTitle(examLib.getLibTitle());
            examLibPaper.setLibContentOne(examLib.getLibContentOne());
            examLibPaper.setLibContentTwo(examLib.getLibContentTwo());
            examLibPaper.setLibContentThree(examLib.getLibContentThree());
            examLibPaper.setLibContentFour(examLib.getLibContentFour());
            examLibPaper.setLibType(examLib.getLibType());
            examLibPaper.setLibOk(examLib.getLibOk());
            examLibPaper.setSort(i + 1);
            examLibPaper.setScore(examLib.getScore());
            examLibPaperDao.insert(examLibPaper);
        }
        return true;
    }

    @Override
    public Map<String, Object> takePart(String userId, String paperId, Integer tmType, Integer index, ExamLibUser examLibUser) {
        Map<String, Object> res = new HashMap<String, Object>();
        List<Map<String, Object>> libs = examUserDao.selectMyPaperLibAll(userId, paperId);
        if (libs.size() > 0) {
            if (tmType == 0) {//初始题目
                res = libs.get(0);
            } else if (tmType == 1) {//上一题目
                if (index == 0) {
                    ExamUser examUser = examUserDao.selectByPaperId(userId, paperId);
                    if (examUser != null) {
                        index = examUser.getLibSort();
                    }
                }
                if (index - 1 > 0) {
                    res = libs.get(index - 2);
                    //更新用户做到第几题的下标
                    ExamUser eu = new ExamUser();
                    eu.setUserId(userId);
                    eu.setPaperId(paperId);
                    eu.setLibSort(index - 1);
                    examUserDao.updateIndexByPaperId(eu);
                }

            } else if (tmType == 2) {//下一题目
                if (index == 0) {
                    ExamUser examUser = examUserDao.selectByPaperId(userId, paperId);
                    if (examUser != null) {
                        index = examUser.getLibSort();
                    }
                }
                if (index <= libs.size()) {
                    //更新用户做到第几题的下标
                    ExamUser eu = new ExamUser();
                    eu.setUserId(userId);
                    eu.setPaperId(paperId);
                    eu.setLibSort(index + 1);
                    eu.setStatus("0");
                    examUserDao.updateIndexByPaperId(eu);
                    //更新做题结果
                    if (StringUtils.isNotBlank(examLibUser.getLibPaperId())) {
                        examLibUser.setId(IdGenerateUtil.uuid3());
                        examLibUser.setUserId(userId);
                        examLibUser.setFinishTime(new Date());
                        ExamLib examLib = examLibDao.selectByPrimaryKey(examLibUser.getLibPaperId());//判断答题是否正确
                        if (StringUtils.equals(examLib.getLibOk(), examLibUser.getLibResult())) {
                            examLibUser.setLibOk("0");
                            examLibUser.setLibScore(examLib.getScore());
                            examLibUser.setLibIntgl(examLib.getScore());
                        } else {
                            examLibUser.setLibOk("1");
                            examLibUser.setLibScore(0);
                            examLibUser.setLibIntgl(0);
                        }
                        ExamLibUser elu = examLibUserDao.selectBylibUserId(userId, examLibUser.getLibPaperId());
                        if (elu == null) {
                            examLibUserDao.insertSelective(examLibUser);
                        } else {
                            examLibUser.setId(elu.getId());
                            examLibUserDao.updateByPrimaryKeySelective(examLibUser);
                        }
                    }
                    //返回题目
                    res = libs.get(index - 1);
                    if (index == libs.size()) {//判断是否为最后一题
                        res.put("isFinish", true);
                    } else {
                        res.put("isFinish", false);
                    }
                }

            } else if (tmType == 3) {//完成
                //完成试卷更新用户做题的下标为0
                ExamUser eu = new ExamUser();
                eu.setUserId(userId);
                eu.setPaperId(paperId);
                eu.setLibSort(0);
                eu.setSendTime(new Date());
                eu.setStatus("2");
                //更新做题结果
                examLibUser.setId(IdGenerateUtil.uuid3());
                examLibUser.setUserId(userId);
                examLibUser.setFinishTime(new Date());
                //更新试卷得分与积分
                Map<String, Object> sMap = examLibUserDao.selectMyPaperScore(userId, paperId);//获取计算试卷分数
                Integer score = Integer.parseInt(sMap.get("score").toString());
                Integer intgl = Integer.parseInt(sMap.get("intgl").toString());

                ExamLib examLib = examLibDao.selectByPrimaryKey(examLibUser.getLibPaperId());//判断答题是否正确
                if (StringUtils.equals(examLib.getLibOk(), examLibUser.getLibResult())) {
                    examLibUser.setLibOk("0");
                    examLibUser.setLibScore(examLib.getScore());
                    examLibUser.setLibIntgl(examLib.getScore());
                    //更新试卷得分与积分 最后一题成功+分
                    score = score + examLib.getScore();
                    intgl = intgl + examLib.getScore();
                    eu.setScore(score);
                    eu.setIntegral(intgl);


                } else {
                    examLibUser.setLibOk("1");
                    examLibUser.setLibScore(0);
                    examLibUser.setLibIntgl(0);
                    //更新试卷得分与积分
                    eu.setScore(score);
                    eu.setIntegral(intgl);
                }

                examUserDao.updateIndexByPaperId(eu);

                ExamLibUser elu = examLibUserDao.selectBylibUserId(userId, examLibUser.getLibPaperId());
                if (elu == null) {
                    examLibUserDao.insertSelective(examLibUser);
                } else {
                    examLibUser.setId(elu.getId());
                    examLibUserDao.updateByPrimaryKeySelective(examLibUser);
                }
                res.put("userId", eu.getUserId());
                res.put("score", eu.getScore());
                res.put("intgl", eu.getIntegral());
            }
        }
        return res;

    }

    @Override
    public Result importLib(String typeId, MultipartFile file, BaseUser baseUser) {
        if (baseUser == null || StringUtils.isBlank(baseUser.getUserId()))
            return Result.failure(ResultCode.USER_NOT_EXIST);
        if (StringUtils.isBlank(typeId)) {
            return Result.failure(ResultCode.PARAM_IS_INVALID);
        }
        KnowType knowType = knowTypeDao.selectByPrimaryKey(typeId);
        if (knowType == null) {
            return Result.failure(ResultCode.PARAM_IS_INVALID);
        }
        //验证文件格式
        String filename = file.getOriginalFilename();
        if (!filename.matches("^.+\\.(?i)(xls)$") && !filename.matches("^.+\\.(?i)(xlsx)$")) {
            return Result.failure(ResultCode.PARAM_FILE_FORMAT);
        }
        List<ExamLib> resList = new ArrayList<ExamLib>();
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        try {
            //读取文件数据转成集合对象
            list = ExcelUtil.importExcel(file, new ExamLibImportBean());
        } catch (IOException e) {
            e.printStackTrace();
            log.error("导入题目异常：" + e.getMessage());
            return Result.failure(ResultCode.PARAM_FILE_IOEX);
        }
        //写入数据
        for (Map<String, Object> map : list) {
            ExamLib el = new ExamLib();
            try {
                el.setLibId(IdGenerateUtil.uuid3());
                el.setCreateName(baseUser.getUserId());
                el.setCreateTime(new Date());
                el.setTypeId(knowType.getTypeId());
                el.setTypeName(knowType.getTypeName());
                el.setLibType(map.get("libType").toString());
                el.setLibTitle(map.get("libTitle").toString());
                el.setLibContentOne(map.get("libContentOne").toString());
                el.setLibContentTwo(map.get("libContentTwo").toString());
                el.setLibContentThree(map.get("libContentThree").toString());
                el.setLibContentFour(map.get("libContentFour").toString());
                el.setLibOk(map.get("libOk").toString());
                el.setScore(Integer.valueOf(map.get("score").toString()));
                String outTime = map.get("outTime").toString();
                el.setOutTime(DateUtils.parseDate(outTime, "yyyy/MM/dd"));
                el.setPriority(Integer.valueOf(map.get("priority").toString()));
                el.setStatus("0");
                el.setDelFlag("0");
                examLibDao.insertSelective(el);
            } catch (Exception e) {
                e.printStackTrace();
                log.error("导入题目数据转换保存异常，" + el.toString() + "; " + e.getMessage());
                resList.add(el);
            }
        }
        return Result.success(resList);
    }

    @Override
    public Result libPaper(String paperId, BaseUser baseUser) {
        if (baseUser == null || StringUtils.isBlank(baseUser.getUserId()))
            return Result.failure(ResultCode.USER_NOT_EXIST);
        if (StringUtils.isBlank(paperId)) return Result.failure(ResultCode.PARAM_IS_INVALID);
        return Result.success(examUserDao.libPaper(baseUser.getUserId(), paperId));
    }

    @Override
    public Result submitPaper(SubmitPaperRequest submitPaperRequest, BaseUser baseUser) {
        if (submitPaperRequest == null) return Result.failure(ResultCode.PARAM_IS_INVALID);
        if (baseUser == null || StringUtils.isBlank(baseUser.getUserId())) {
            return Result.failure(ResultCode.USER_NOT_EXIST);
        } else {
            submitPaperRequest.setUserId(baseUser.getUserId());
        }
        if (StringUtils.isBlank(submitPaperRequest.getUserId())) return Result.failure(ResultCode.PARAM_IS_INVALID);
        if (StringUtils.isBlank(submitPaperRequest.getPaperId())) return Result.failure(ResultCode.PARAM_IS_INVALID);
        if (submitPaperRequest.getResults() == null || submitPaperRequest.getResults().isEmpty())
            return Result.failure(ResultCode.PARAM_IS_INVALID);
        ExamUser examUser = examUserDao.selectByPaperId(submitPaperRequest.getUserId(), submitPaperRequest.getPaperId());
        if (examUser == null) return Result.failure(ResultCode.PARAM_IS_INVALID);
        if (StringUtils.isNotBlank(examUser.getStatus()) && examUser.getStatus().equals(1))
            return Result.failure(ResultCode.PARAM_IS_INVALID);
        List<ExamLibPaper> examLibPapers = examUserDao.libPaper(submitPaperRequest.getUserId(), submitPaperRequest.getPaperId());
        if (examLibPapers == null || examLibPapers.isEmpty()) return Result.failure(ResultCode.PARAM_IS_INVALID);
        // 计算分数
        Integer score = 0;
        Integer totalScore = examUserDao.totalScore(submitPaperRequest.getUserId(), submitPaperRequest.getPaperId());
        for (SubmitPaperResultRequest submitPaperResultRequest : submitPaperRequest.getResults()) {
            for (ExamLibPaper examLibPaper : examLibPapers) {
                if (submitPaperResultRequest.getLibPaperId().equals(examLibPaper.getId()) && submitPaperResultRequest.getLibResult().equals(examLibPaper.getLibOk())) {
                    score += examLibPaper.getScore() == null ? 0 : examLibPaper.getScore();
                }
            }
        }
        examUser.setScore(MathUtil.percentage(score, totalScore));
        examUser.setStatus(String.valueOf(1));
        examUser.setSendTime(new Date());
        examUserDao.updateByPrimaryKey(examUser);
        return Result.success(examUser.getScore());
    }

    @Override
    public Result updatePaperStatus(String paperId, String status) {
        if (StringUtils.isBlank(paperId)) return Result.failure(ResultCode.PARAM_IS_INVALID);
        if (StringUtils.isBlank(status)) return Result.failure(ResultCode.PARAM_IS_INVALID);
        ExamPaper examPaper = examPaperDao.selectByPrimaryKey(paperId);
        if (examPaper == null) return Result.failure(ResultCode.PARAM_IS_INVALID);
        if (status.equals("0")) {
            examPaper.setSendTime(new Date());
        }
        examPaper.setStatus(status);
        examPaperDao.updateByPrimaryKey(examPaper);
        return Result.success();
    }
}
