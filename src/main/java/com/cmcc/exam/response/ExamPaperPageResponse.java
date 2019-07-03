package com.cmcc.exam.response;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @author zwq
 * @create 2019-06-24 15:14
 */
public class ExamPaperPageResponse {
    private String paperId;
    /**
     * 试卷名称
     */
    private String paperTitle;
    /**
     * 试卷简介
     */
    private String paperBrief;
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
    private Date sendTime;
    /**
     * 备注
     */
    private String remark;
    private Integer total;
    /**
     * 0已发布，1未发布，2已过期
     */
    private String status;
    /**
     * 知识分类ID
     */
    private String typeId;
    /**
     * 知识分类名称
     */
    private String typeName;

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
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

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
