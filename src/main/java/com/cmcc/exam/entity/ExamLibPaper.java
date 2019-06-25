package com.cmcc.exam.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ExamLibPaper {
    private String id;
    @JsonIgnore
    private String libId;
    @JsonIgnore
    private String paperId;

    private String libType;

    private String libTitle;

    private String libContentOne;

    private String libContentTwo;

    private String libContentThree;

    private String libContentFour;
    @JsonIgnore
    private String libOk;
    @JsonIgnore
    private Integer score;
    @JsonIgnore
    private Integer sort;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getLibId() {
        return libId;
    }

    public void setLibId(String libId) {
        this.libId = libId == null ? null : libId.trim();
    }

    public String getPaperId() {
        return paperId;
    }

    public void setPaperId(String paperId) {
        this.paperId = paperId == null ? null : paperId.trim();
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

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}