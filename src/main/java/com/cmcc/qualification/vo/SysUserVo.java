package com.cmcc.qualification.vo;

import java.util.List;
import java.util.Map;

import com.cmcc.qualification.entity.ProPertificate;


public class SysUserVo {
	/*用户实体*/
	private Map<String, Object> sysUser;
	/*资质信息实体集合*/
	private List<ProPertificate> proPertificateLists;
	
	public List<ProPertificate> getProPertificateLists() {
		return proPertificateLists;
	}
	public void setProPertificateLists(List<ProPertificate> proPertificateLists) {
		this.proPertificateLists = proPertificateLists;
	}
	public Map<String, Object> getSysUser() {
		return sysUser;
	}
	public void setSysUser(Map<String, Object> userInfo) {
		this.sysUser = userInfo;
	}
	
	

}
