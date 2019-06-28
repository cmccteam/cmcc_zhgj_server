package com.cmcc.qualification.entity;

import java.util.Date;
import java.util.List;
import java.util.Map;

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
	private String fileUrls;
	@ApiParam(hidden=true)
	private String createUser;
	@ApiParam(hidden=true)
	private Date createTime;
	@ApiParam(value="公司备注",required = false)
	private String remarks;

	@ApiParam(hidden=true)
	private List<Map<String, Object>> users;
	
	
	public List<Map<String, Object>> getUsers() {
		return users;
	}

	public void setUsers(List<Map<String, Object>> users) {
		this.users = users;
	}

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

	public String getFileUrls() {
		return fileUrls;
	}

	public void setFileUrls(String fileUrls) {
		this.fileUrls = fileUrls;
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

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getComqPinyin() {
		return comqPinyin;
	}

	public void setComqPinyin(String comqPinyin) {
		this.comqPinyin = comqPinyin;
	}
	
	

}
