package com.cmcc.qualification.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cmcc.qualification.entity.ProCompanyQua;
import com.github.pagehelper.Page;


/**
 * 公司资质信息dao接口
 * @author Administrator
 *
 */
@Mapper
public interface ProCompanyQuaDao {
	/**
	 * 根据公司名称模糊查询公司资质表
	 * @param comqName 
	 * @return 返回完整的公司名称和id
	 */
	List<Map<String, String>> getList(String comqNameOrComqPinyin);
	
	/**
	 * 根据完整公司名称(或者公司id)查询公司资质表
	 * @param comqId 公司id
	 * @return 返回公司资质信息
	 */
	ProCompanyQua getCompanyInfo(String comqId);

	/**
	 * 新增公司信息
	 * @param proCompanyQua 公司信息实体
	 * @return
	 */
	Integer addProCompanyQua(ProCompanyQua proCompanyQua);

	/**
	 * 根据公司资质id更新公司信息
	 * @param proCompanyQua 公司信息实体
	 * @return
	 */
	Integer saveProCompanyQua(ProCompanyQua proCompanyQua);

	/**
	 * 查询所有公司信息
	 * @return
	 */
	List<ProCompanyQua> selectAllProCompanyQuas();

	/**
	 * 后台管理查询公司列表
	 * @return
	 */
	Page<ProCompanyQua> selectAllCompanyQuas();

}
