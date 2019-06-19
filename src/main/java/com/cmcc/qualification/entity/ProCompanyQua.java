package com.cmcc.qualification.entity;

import java.util.Date;

import io.swagger.annotations.ApiParam;

/**
 * 公司资质信息
 * @author Administrator
 *
 */
public class ProCompanyQua{
	@ApiParam(hidden=true)
	private String comqId;
	@ApiParam(value="公司名称",required = false)
	private String comqName;
	@ApiParam(value="公司名称拼音",required = false)
	private String comqPinyin;
	@ApiParam(value="工商注册号",required = false)
	private String comqCode;
	@ApiParam(value="经营范围",required = false)
	private String businessScope;
	@ApiParam(value="经营期限",required = false)
	private String businessDeadline;
	@ApiParam(value="注册地点",required = false)
	private String regPlace;
	@ApiParam(value="营业执照图片地址",required = false)
	private String fileUrl;
	@ApiParam(hidden=true)
	private String createUser;
	@ApiParam(hidden=true)
	private Date createTime;
	@ApiParam(value="备注",required = false)
	private String remark;

	public String getComqId() {
		return comqId;
	}

	public void setComqId(String comqId) {
		this.comqId = comqId;
	}

	public String getComqName() {
		return comqName;
	}

	public void setComqName(String comqName) {
		this.comqName = comqName;
	}

	public String getComqCode() {
		return comqCode;
	}

	public void setComqCode(String comqCode) {
		this.comqCode = comqCode;
	}

	public String getBusinessScope() {
		return businessScope;
	}

	public void setBusinessScope(String businessScope) {
		this.businessScope = businessScope;
	}

	public String getBusinessDeadline() {
		return businessDeadline;
	}

	public void setBusinessDeadline(String businessDeadline) {
		this.businessDeadline = businessDeadline;
	}

	public String getRegPlace() {
		return regPlace;
	}

	public void setRegPlace(String regPlace) {
		this.regPlace = regPlace;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getComqPinyin() {
		return comqPinyin;
	}

	public void setComqPinyin(String comqPinyin) {
		this.comqPinyin = comqPinyin;
	}
	
	

}
