package com.cmcc.qualification.vo;

import java.util.List;
import java.util.Map;

import com.cmcc.qualification.entity.ProCompanyUser;
import com.cmcc.qualification.entity.ProPertificate;


public class SysUserVo {
	/*用户实体*/
	private ProCompanyUser proCompanyUser;
	/*资质信息实体集合*/
	private List<ProPertificate> proPertificateLists;
	
	public List<ProPertificate> getProPertificateLists() {
		return proPertificateLists;
	}
	public void setProPertificateLists(List<ProPertificate> proPertificateLists) {
		this.proPertificateLists = proPertificateLists;
	}
	public ProCompanyUser getProCompanyUser() {
		return proCompanyUser;
	}
	public void setProCompanyUser(ProCompanyUser proCompanyUser) {
		this.proCompanyUser = proCompanyUser;
	}
	
	
	

}
