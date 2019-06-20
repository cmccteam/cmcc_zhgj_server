package com.cmcc.qualification.service;

import java.util.List;
import java.util.Map;

import com.cmcc.qualification.entity.ProCompanyQua;
import com.cmcc.qualification.entity.ProPertificate;
import com.github.pagehelper.Page;

/**
 * 公司资质管理业务层
 * @author Administrator
 *
 */
public interface CompanyQualificationService {
	
	/**
	 * 根据输入文字模糊查询出所有匹配的公司名称
	 * @param comqName 包含用户输入字段信息（公司名称comqName）
	 * @return  所有公司名称和id集合
	 */
	List<Map<String, String>> getList(String comqNameOrComqPinyin);

	/**
	 * 根据公司名称查询公司资质信息
	 * @param comqId 包含用户输入字段信息（公司资质id）
	 * @return 公司资质信息对象
	 */
	ProCompanyQua getCompanyInfo(String comqId);

	/**
	 * 根据实体对象新增公司资质
	 * @param proCompanyQua 公司信息对象
	 * @param proPertificate 
	 * @return 
	 */
	Integer add(ProCompanyQua proCompanyQua, ProPertificate proPertificate);

	/**
	 * 根据实体对象更新公司资质
	 * @param proCompanyQua 公司信息对象
	 * @param proPertificate 
	 * @return 
	 */
	Integer save(ProCompanyQua proCompanyQua);

	/**
	 * 查询所有公司并按照公司首字母进行分组排序
	 * @return
	 */
	Map<String, List<ProCompanyQua>> getAllProCompanyQua();

	/**
	 * 后台管理查询公司列表
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	Page<ProCompanyQua> getProCompanyQua(Integer pageNum, Integer pageSize,String comqNameOrComqPinyin);

}
