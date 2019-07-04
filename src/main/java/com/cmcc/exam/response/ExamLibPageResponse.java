package com.cmcc.exam.response;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @author zwq
 * @create 2019-07-04 15:09
 */
public class ExamLibPageResponse {
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    public String getLibId() {
        return libId;
    }

    public void setLibId(String libId) {
        this.libId = libId;
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

    public String getLibType() {
        return libType;
    }

    public void setLibType(String libType) {
        this.libType = libType;
    }

    public String getLibTitle() {
        return libTitle;
    }

    public void setLibTitle(String libTitle) {
        this.libTitle = libTitle;
    }

    public String getLibContentOne() {
        return libContentOne;
    }

    public void setLibContentOne(String libContentOne) {
        this.libContentOne = libContentOne;
    }

    public String getLibContentTwo() {
        return libContentTwo;
    }

    public void setLibContentTwo(String libContentTwo) {
        this.libContentTwo = libContentTwo;
    }

    public String getLibContentThree() {
        return libContentThree;
    }

    public void setLibContentThree(String libContentThree) {
        this.libContentThree = libContentThree;
    }

    public String getLibContentFour() {
        return libContentFour;
    }

    public void setLibContentFour(String libContentFour) {
        this.libContentFour = libContentFour;
    }

    public String getLibOk() {
        return libOk;
    }

    public void setLibOk(String libOk) {
        this.libOk = libOk;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
