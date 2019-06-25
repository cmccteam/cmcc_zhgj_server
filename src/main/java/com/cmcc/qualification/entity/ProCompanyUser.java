package com.cmcc.qualification.entity;

public class ProCompanyUser {
    private String cpUserId;

    private String comqId;

    private String userId;

    private String userName;

    private String userTel;

    public String getCpUserId() {
        return cpUserId;
    }

    public void setCpUserId(String cpUserId) {
        this.cpUserId = cpUserId == null ? null : cpUserId.trim();
    }

    public String getComqId() {
        return comqId;
    }

    public void setComqId(String comqId) {
        this.comqId = comqId == null ? null : comqId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel == null ? null : userTel.trim();
    }
}