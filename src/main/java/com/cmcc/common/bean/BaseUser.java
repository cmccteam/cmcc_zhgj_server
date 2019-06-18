package com.cmcc.common.bean;

import io.swagger.annotations.ApiParam;

public class BaseUser {
	@ApiParam(hidden=true)
	private String userId;
	@ApiParam(hidden=true)
	private String userAccount;
	@ApiParam(hidden=true)
	private String userName;
	@ApiParam(hidden=true)
	private String userTel;
	@ApiParam(hidden=true)
	private String orgId;
	@ApiParam(hidden=true)
	private String companyId;
	@ApiParam(hidden=true)
	private String tenantId;
	@ApiParam(hidden=true)
	private String faceUrl;
	
	
	public String getFaceUrl() {
		return faceUrl;
	}
	public void setFaceUrl(String faceUrl) {
		this.faceUrl = faceUrl;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserTel() {
		return userTel;
	}
	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getTenantId() {
		return tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	
	
}
