package com.cmcc.qualification.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cmcc.common.utils.IdGenerateUtil;
import com.cmcc.common.utils.Sort;
import com.cmcc.qualification.dao.ProCompanyQuaDao;
import com.cmcc.qualification.dao.ProPertificateDao;
import com.cmcc.qualification.entity.ProCompanyQua;
import com.cmcc.qualification.entity.ProPertificate;
import com.cmcc.qualification.service.CompanyQualificationService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
/**
 * 公司资质管理业务层
 * @author Administrator
 *
 */
@Service("companyQualificationService")
public class CompanyQualificationServiceImpl implements CompanyQualificationService {

	@Autowired
	private ProCompanyQuaDao proCompanyQuaDao;
	
	@Autowired
	private ProPertificateDao proPertificateDao;
	
	@Override
	public List<Map<String, String>> getList(String comqNameOrComqPinyin) {
		return proCompanyQuaDao.getList(comqNameOrComqPinyin);
	}
	
	@Override
	public ProCompanyQua getCompanyInfo(String comqId) {
		return proCompanyQuaDao.getCompanyInfo(comqId);
	}

	@Override
	@Transactional
	public Integer add(ProCompanyQua proCompanyQua, ProPertificate proPertificate) {
		proCompanyQua.setComqId(IdGenerateUtil.uuid3());
		proCompanyQua.setCreateTime(new Date());
		proPertificate.setFileUrl(proCompanyQua.getFileUrls());
		proPertificate.setCertificateId(IdGenerateUtil.uuid3());
		proPertificate.setFkcertId(proCompanyQua.getComqId());
		proPertificate.setCreateTime(new Date());
		Integer t = proCompanyQuaDao.addProCompanyQua(proCompanyQua);
		Integer f = proPertificateDao.addProPertificate(proPertificate);
		return t+f;
	}

	@Override
	public Integer save(ProCompanyQua proCompanyQua) {
		return proCompanyQuaDao.saveProCompanyQua(proCompanyQua);
	}

	@Override
	public Map<String, List<ProCompanyQua>> getAllProCompanyQua() {
		Map<String, List<ProCompanyQua>> resultMap = new HashMap<String, List<ProCompanyQua>>();
		List<ProCompanyQua> companyList  = proCompanyQuaDao.selectAllProCompanyQuas();
		System.out.println("公司："+companyList);
		if (companyList.size() > 0) {
			for (ProCompanyQua cInfo : companyList) {
				// map中的key是否包含人员首字母，存在则直接添加,否则新建key然后添加进去
				if (resultMap.containsKey(String.valueOf(cInfo.getComqPinyin().charAt(0)).toUpperCase())) {
					resultMap.get(String.valueOf(cInfo.getComqPinyin().charAt(0)).toUpperCase()).add(cInfo);
				}else {
					List<ProCompanyQua> tempList = new ArrayList<ProCompanyQua>();
					tempList.add(cInfo);
					resultMap.put(String.valueOf(cInfo.getComqPinyin().charAt(0)).toUpperCase(), tempList);
				}
		    }
		 }
		return Sort.sortCampany(resultMap);
	}

	@Override
	public Page<ProCompanyQua> getProCompanyQua(Integer pageNum, Integer pageSize,String comqNameOrComqPinyin) {
		PageHelper.startPage(pageNum, pageSize);
		return proCompanyQuaDao.selectAllCompanyQuas(comqNameOrComqPinyin);
	}

	@Override
	@Transactional
	public Integer del(String comqId) {
		proPertificateDao.deleteByFkcertId(comqId);
		return proCompanyQuaDao.deleteByPrimaryKey(comqId);
	}

	

}
