package com.cmcc.exam.response;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @author zwq
 * @create 2019-06-24 15:14
 */
public class MyExamPaperPageResponse {
    /**
     * 试卷ID
     */
    private String paperId;
    /**
     * 试卷名
     */
    private String paperTitle;
    /**
     * 试卷描述
     */
    private String paperBrief;
    /**
     * 备注
     */
    private String remark;
    /**
     * 考试人数
     */
    private Integer total;
    /**
     * 状态（是否参与）
     */
    private String status;
    /**
     * 提交时间
     */
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
    private Date sendTime;
    /**
     * 总分数
     */
    private Integer score;

    public String getPaperId() {
        return paperId;
    }

    public void setPaperId(String paperId) {
        this.paperId = paperId;
    }

    public String getPaperTitle() {
        return paperTitle;
    }

    public void setPaperTitle(String paperTitle) {
        this.paperTitle = paperTitle;
    }

    public String getPaperBrief() {
        return paperBrief;
    }

    public void setPaperBrief(String paperBrief) {
        this.paperBrief = paperBrief;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
