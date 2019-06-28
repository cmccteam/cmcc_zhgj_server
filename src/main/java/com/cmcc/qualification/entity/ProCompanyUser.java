package com.cmcc.qualification.entity;

import io.swagger.annotations.ApiParam;

public class ProCompanyUser {
	@ApiParam(hidden=true) 
    private String cpUserId;
	@ApiParam(value="施工单位ID",required = false)
    private String comqId;
	@ApiParam(value="施工人员用户ID",required = false)
    private String userId;
	@ApiParam(value="用户姓名",required = false)
    private String userName;
	@ApiParam(value="用户手机号",required = false)
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