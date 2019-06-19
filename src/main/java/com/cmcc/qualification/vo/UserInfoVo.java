package com.cmcc.qualification.vo;

import io.swagger.annotations.ApiParam;

/**
 * 接收前端参数vo
 * @author Administrator
 *
 */
public class UserInfoVo {
	@ApiParam(name="userId",value="用户id",required=true)
	private String userId;//用户id
	
	@ApiParam(name="id",value="用户修改项目名称时，用来保存原项目id",required=true)
	private String id;
	
	//@ApiParam(name="userName",value="用户名称",required=true)
	private String userName;//用户名称
	
	@ApiParam(name="userPinyin",value="拼音字段",required=true)
	private String userPinyin;
	
	@ApiParam(name="avatarUrl",value="用户头像",required=true)
	private String avatarUrl;//用户头像
	
	@ApiParam(name="userTel",value="用户电话",required=true)
	private String userTel;
	
	@ApiParam(name="projectName",value="项目名称",required=true)
	private String projectName;//项目名称
	
	@ApiParam(name="postId",value="任职职位id",required=true)
	private String postId;//任职职位id
	
	@ApiParam(name="post",value="职位",required=true)
	private String post;//职位
	
	@ApiParam(name="intoTime",value="进入项目时间",required=true)
	private String intoTime;//进入项目时间
	
	@ApiParam(name="topName",value="公司名称",required=true)
	private String topName;//公司名称
	
	@ApiParam(name="projectId",value="项目id",required=true)
	private String projectId;//项目id
	
	@ApiParam(name="orgId",value="公司id",required=true)
	private String orgId;//公司id
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAvatarUrl() {
		return avatarUrl;
	}
	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getIntoTime() {
		return intoTime;
	}
	public void setIntoTime(String intoTime) {
		this.intoTime = intoTime;
	}
	public String getTopName() {
		return topName;
	}
	public void setTopName(String topName) {
		this.topName = topName;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	public String getUserTel() {
		return userTel;
	}
	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserPinyin() {
		return userPinyin;
	}
	public void setUserPinyin(String userPinyin) {
		this.userPinyin = userPinyin;
	}
	public String getPostId() {
		return postId;
	}
	public void setPostId(String postId) {
		this.postId = postId;
	}
	
	
	
	
	
	
	
	

}
