package com.cmcc.qualification.entity;

import java.util.Date;

import io.swagger.annotations.ApiParam;

/**
 * 资质信息类
 * @author Administrator
 *
 */
public class ProPertificate {
	@ApiParam(hidden=true)
	private String certificateId;
	@ApiParam(value="资质ID(用户ID，公司ID)",required = false)
	private String fkcertId;
	@ApiParam(value="资质类型(个人，公司)",required = false)
	private String certificateType;
	@ApiParam(value="资质名称",required = false)
	private String certificateName;
	@ApiParam(value="资质证号",required = false)
	private String certificateCode;
	@ApiParam(value="作业类别",required = false)
	private String jobCategory;
	@ApiParam(value="准操项目",required = false)
	private String permitProject;
	@ApiParam(hidden=true)
	private Date firstDate;
	@ApiParam(hidden=true)
	private Date effectiveDate;
	@ApiParam(value="图片路径(多张用#隔开)",required = false)
	private String fileUrl;
	@ApiParam(hidden=true)
	private String createUser;
	@ApiParam(hidden=true)
	private Date createTime;
	@ApiParam(value="备注",required = false)
	private String remark;
	@ApiParam(value="有效期",required = false)
	private String stringEffectiveDate;
	
	@ApiParam(hidden=true)
	private String fileId;
	
	
	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public String getCertificateId() {
		return certificateId;
	}

	public void setCertificateId(String certificateId) {
		this.certificateId = certificateId;
	}

	public String getFkcertId() {
		return fkcertId;
	}

	public void setFkcertId(String fkcertId) {
		this.fkcertId = fkcertId;
	}

	public String getCertificateType() {
		return certificateType;
	}

	public void setCertificateType(String certificateType) {
		this.certificateType = certificateType;
	}

	public String getCertificateName() {
		return certificateName;
	}

	public void setCertificateName(String certificateName) {
		this.certificateName = certificateName;
	}

	public String getCertificateCode() {
		return certificateCode;
	}

	public void setCertificateCode(String certificateCode) {
		this.certificateCode = certificateCode;
	}

	public String getJobCategory() {
		return jobCategory;
	}

	public void setJobCategory(String jobCategory) {
		this.jobCategory = jobCategory;
	}

	public String getPermitProject() {
		return permitProject;
	}

	public void setPermitProject(String permitProject) {
		this.permitProject = permitProject;
	}

	public Date getFirstDate() {
		return firstDate;
	}

	public void setFirstDate(Date firstDate) {
		this.firstDate = firstDate;
	}

	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
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

	public String getStringEffectiveDate() {
		return stringEffectiveDate;
	}

	public void setStringEffectiveDate(String stringEffectiveDate) {
		this.stringEffectiveDate = stringEffectiveDate;
	}
	
	

}
