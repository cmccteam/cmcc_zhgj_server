package com.cmcc.qualification.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.cmcc.qualification.entity.ProCompanyUser;
import com.cmcc.qualification.entity.ProPertificate;
import com.cmcc.qualification.vo.SysUserVo;
import com.cmcc.qualification.vo.UserInfoVo;
import com.github.pagehelper.Page;


/**
 * 资质信息业务层
 * @author Administrator
 *
 */
public interface PersonalQualificationService {

	/**
	 * 根据用户名称查询用户
	 * @param userName 用户名称
	 * @param userPinyin 
	 * @return 一个或多个对应用户
	 */
	Map<String, String> getList(String userNameAndPinyin);

	/**
	 * 根据用户id查询用户信息
	 * @param userId 用户id
	 * @return
	 */
	SysUserVo getUserinfo(String userId);

	/**
	 * 根据用户id更新用户人员信息
	 * @param userInfoVo 用户id
	 * @return
	 */
	Integer saveUserinfo(UserInfoVo userInfoVo);


	/**
	 * 查询人员名单列表并按照首字母分组
	 * @return
	 */
	Map<String, List<UserInfoVo>> allUserinfo();

	/**
	 * 导入添加个人资质信息
	 * @param fileName
	 * @param file
	 * @return
	 * @throws Exception 
	 */
	Boolean batchImportUsers(String fileName, MultipartFile file) throws Exception;

	/**
	 * 根据用户id增加个人资质信息
	 * @param proPertificate 资质信息
	 * @param userId 用户id
	 * @return
	 */
	Integer addProPertificate(ProPertificate proPertificate, String userId);

	/**
	 * 根据资质信息id查询个人资质详情
	 * @param certificateId 资质信息id
	 * @return
	 */
	ProPertificate getPersonalQualificationInfo(String certificateId);

	/**
	 * 根据个人资质id删除对应资质信息
	 * @param certificateId 资质信息id
	 * @return
	 */
	Boolean delPersonalQualificationInfo(String certificateId,String comqId,String userId) throws Exception;

	/**
	 * 分页获取个人信息
	 * @param pageNum
	 * @param pageSize
	 * @param orderBy
	 * @param proCompanyUser
	 * @param baseUser
	 * @return
	 */
	Page<Map<String,String>> getPage(Integer pageNum, Integer pageSize, String orderBy, ProCompanyUser proCompanyUser);

	Integer addCpUser(ProCompanyUser proCompanyUser,List<ProPertificate> listproPertificates,String userAccount,String tenantId) throws Exception;

	List<Map<String, String>> getUserList(ProCompanyUser proCompanyUser);

	Integer saveProPertificate(ProPertificate proPertificate, String certificateId);

}
