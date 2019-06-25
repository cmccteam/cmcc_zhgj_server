package com.cmcc.common.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiParam;


public class SysUser implements Comparable<SysUser> {
	@ApiParam(hidden=true) 
    private String userId;
	@ApiParam(value="账号",required = false)
    private String userAccount;
	@ApiParam(value="密码，给注册用的",required = false)
	private String userPass;
	@ApiParam(value="租户ID，给注册用的",required = false)
    private String tenantId;
    @ApiParam(value="姓名",required = false)
    private String userName;
    @ApiParam(value="姓名拼音",required = false)
    private String userPinyin;
    @ApiParam(value="手机号码",required = false)
    private String userTel;
    @ApiParam(value="手机短号",required = false)
    private String scTel;
    @ApiParam(value="固定电话",required = false)
    private String fixedTel;
    @ApiParam(value="邮箱",required = false)
    private String email;
    @ApiParam(value="性别",required = false)
    private Integer sex;
    @ApiParam(value="职务",required = false)
    private String job;
    @ApiParam(value="公司CODE",required = false)
    private String orgCode;
    @ApiParam(hidden=true)
    private String companyName;
    @ApiParam(value="头像地址",required = false)
    private String avatarUrl;
    @ApiParam(value="机构部门ID",required = false)
    private String orgId;
    @ApiParam(hidden=true)
    private String orgName;
    @ApiParam(value="角色ID",required = false)
    private String roleId;
    @ApiParam(hidden=true)
    private String createUser;
    @ApiParam(hidden=true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @ApiParam(hidden=true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date lastTime;
    @ApiParam(hidden=true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date passupTime;
    @ApiParam(value="用户状态0在职1离职",required = false)
    private String status;
    @ApiParam(hidden=true)
    private String delFlag;
    @ApiParam(hidden=true)
    private Integer sort;

    public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public String getFixedTel() {
		return fixedTel;
	}

	public void setFixedTel(String fixedTel) {
		this.fixedTel = fixedTel;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount == null ? null : userAccount.trim();
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass == null ? null : userPass.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPinyin() {
        return userPinyin;
    }

    public void setUserPinyin(String userPinyin) {
        this.userPinyin = userPinyin == null ? null : userPinyin.trim();
    }


    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel == null ? null : userTel.trim();
    }


    public String getScTel() {
		return scTel;
	}

	public void setScTel(String scTel) {
		this.scTel = scTel;
	}

	public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

	public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl == null ? null : avatarUrl.trim();
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    public Date getPassupTime() {
        return passupTime;
    }

    public void setPassupTime(Date passupTime) {
        this.passupTime = passupTime;
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

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

	@Override
	public int compareTo(SysUser o) {
		return this.getSort().compareTo(o.getSort());
	}
}