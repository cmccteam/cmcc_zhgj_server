package com.cmcc.qualification.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cmcc.qualification.entity.ProPertificate;


/**
 * 资质信息dao接口
 * @author Administrator
 *
 */
@Mapper
public interface ProPertificateDao {
	
	/**
	 * 新增资质信息
	 * @param proPertificate资质信息实体
	 * @return
	 */
	Integer addProPertificate(ProPertificate proPertificate);

	/**
	 * 根据用户id查询该用户所有资质信息
	 * @param userId
	 * @return
	 */
	List<ProPertificate> selectAllProPertificateByUserId(String userId);

	/**
	 * 根据个人资质信息id查询资质详情
	 * @param certificateId 资质信息id
	 * @return
	 */
	ProPertificate getPersonalQualificationInfo(String certificateId);

	/**
	 * 根据个人资质信息id删除对应资质
	 * @param certificateId 资质信息id
	 * @return
	 */
	Boolean delPersonalQuaInfo(String certificateId);

	/**
	 * 根据公司资质删除工资资质信息
	 * @param comqId
	 * @return
	 */
	Integer deleteByFkcertId(@Param(value="comqId") String comqId);

	Integer updateByPrimarySelective(ProPertificate proPertificate);

}
