package com.cmcc.exam.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.Set;

/**
 * ClassName: ExamPaper
 *
 * @author zengzhibin
 * @Description: TODO 试卷实体
 * @date 2019年3月4日
 */
@ApiModel(value = "试卷实体", description = "试卷实体")
public class ExamPaper {

    @ApiModelProperty(hidden = true)
    private String paperId;
    @ApiModelProperty(value = "试卷名称", required = true)
    private String paperTitle;
    @ApiModelProperty(value = "试卷简介", required = true)
    private String paperBrief;
    @ApiModelProperty(hidden = true)
    private String createName;
    @ApiModelProperty(hidden = true)
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    @ApiModelProperty(hidden = true)
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
    private Date sendTime;
    @ApiModelProperty(value = "备注")
    private String remark;
    @ApiModelProperty(hidden = true)
    private Integer total;
    @ApiModelProperty(value = "0已发布，1未发布，2已过期", allowableValues = "0, 1, 2", required = true)
    private String status;
    @ApiModelProperty(value = "知识分类ID", required = true)
    private String typeId;

    @ApiModelProperty(value = "考试用户", required = true)
    private Set<String> userId;
    @ApiModelProperty(value = "考试题目数量", required = true)
    private Integer rows;


    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Set<String> getUserId() {
        return userId;
    }

    public void setUserId(Set<String> userId) {
        this.userId = userId;
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

    public String getPaperId() {
        return paperId;
    }

    public void setPaperId(String paperId) {
        this.paperId = paperId == null ? null : paperId.trim();
    }

    public String getPaperTitle() {
        return paperTitle;
    }

    public void setPaperTitle(String paperTitle) {
        this.paperTitle = paperTitle == null ? null : paperTitle.trim();
    }

    public String getPaperBrief() {
        return paperBrief;
    }

    public void setPaperBrief(String paperBrief) {
        this.paperBrief = paperBrief == null ? null : paperBrief.trim();
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName == null ? null : createName.trim();
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
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}