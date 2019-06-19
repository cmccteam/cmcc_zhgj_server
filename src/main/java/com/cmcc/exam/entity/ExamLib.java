package com.cmcc.exam.entity;

import java.util.Date;

public class ExamLib {
    private String libId;

    private String typeId;

    private String typeName;

    private String libType;

    private String libTitle;

    private String libContentOne;

    private String libContentTwo;

    private String libContentThree;

    private String libContentFour;

    private String libOk;

    private Integer score;

    private String createName;

    private Date createTime;

    private Date outTime;

    private Integer priority;

    private String status;

    private String delFlag;

    public String getLibId() {
        return libId;
    }

    public void setLibId(String libId) {
        this.libId = libId == null ? null : libId.trim();
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId == null ? null : typeId.trim();
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    public String getLibType() {
        return libType;
    }

    public void setLibType(String libType) {
        this.libType = libType == null ? null : libType.trim();
    }

    public String getLibTitle() {
        return libTitle;
    }

    public void setLibTitle(String libTitle) {
        this.libTitle = libTitle == null ? null : libTitle.trim();
    }

    public String getLibContentOne() {
        return libContentOne;
    }

    public void setLibContentOne(String libContentOne) {
        this.libContentOne = libContentOne == null ? null : libContentOne.trim();
    }

    public String getLibContentTwo() {
        return libContentTwo;
    }

    public void setLibContentTwo(String libContentTwo) {
        this.libContentTwo = libContentTwo == null ? null : libContentTwo.trim();
    }

    public String getLibContentThree() {
        return libContentThree;
    }

    public void setLibContentThree(String libContentThree) {
        this.libContentThree = libContentThree == null ? null : libContentThree.trim();
    }

    public String getLibContentFour() {
        return libContentFour;
    }

    public void setLibContentFour(String libContentFour) {
        this.libContentFour = libContentFour == null ? null : libContentFour.trim();
    }

    public String getLibOk() {
        return libOk;
    }

    public void setLibOk(String libOk) {
        this.libOk = libOk == null ? null : libOk.trim();
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
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

    public Date getOutTime() {
        return outTime;
    }

    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }
}