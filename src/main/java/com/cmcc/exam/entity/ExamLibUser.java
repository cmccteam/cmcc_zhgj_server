package com.cmcc.exam.entity;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="用户做题结果实体",description="用户做题结果实体")
public class ExamLibUser {
	@ApiModelProperty(hidden=true)
    private String id;
	@ApiModelProperty(hidden=true)
    private String userId;
	@ApiModelProperty(value="题目ID",required=false)
    private String libPaperId;
	@ApiModelProperty(value="做题结果",required=false)
    private String libResult;
	@ApiModelProperty(hidden=true)
    private String libOk;
	@ApiModelProperty(hidden=true)
    private Integer libScore;
	@ApiModelProperty(hidden=true)
    private Integer libIntgl;
	@ApiModelProperty(hidden=true)
    private Date finishTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getLibPaperId() {
        return libPaperId;
    }

    public void setLibPaperId(String libPaperId) {
        this.libPaperId = libPaperId == null ? null : libPaperId.trim();
    }

    public String getLibResult() {
        return libResult;
    }

    public void setLibResult(String libResult) {
        this.libResult = libResult == null ? null : libResult.trim();
    }

    public String getLibOk() {
        return libOk;
    }

    public void setLibOk(String libOk) {
        this.libOk = libOk == null ? null : libOk.trim();
    }

    public Integer getLibScore() {
        return libScore;
    }

    public void setLibScore(Integer libScore) {
        this.libScore = libScore;
    }

    public Integer getLibIntgl() {
        return libIntgl;
    }

    public void setLibIntgl(Integer libIntgl) {
        this.libIntgl = libIntgl;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }
}