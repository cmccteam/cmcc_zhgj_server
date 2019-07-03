package com.cmcc.qualification.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;


import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.cmcc.common.bean.BaseUser;
import com.cmcc.common.bean.Result;
import com.cmcc.common.bean.ResultCode;
import com.cmcc.config.interceptor.CurrentUser;
import com.cmcc.qualification.entity.ProCompanyUser;
import com.cmcc.qualification.entity.ProPertificate;
import com.cmcc.qualification.service.PersonalQualificationService;
import com.cmcc.qualification.vo.SysUserVo;
import com.cmcc.qualification.vo.UserInfoVo;
import com.github.pagehelper.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * ClassName: PersonalQualificationController 
 * @Description: 个人资质管理控制层
 * @author liuhaihe
 * @date 2019年2月28日
 */
@Api(value="个人资质管理接口")
@RestController
@RequestMapping("/personalQualification")
public class PersonalQualificationController{
	/**
	 * 个人资质管理业务实现类
	 */
	@Autowired
	private PersonalQualificationService personalQualificationService;
	
    private static Logger LOGGER = LoggerFactory.getLogger(PersonalQualificationController.class);
	
    
    @ApiOperation(value="分页获取个人信息", notes="分页获取个人信息")
	@GetMapping(value = "/getPage")
	public Result getPage(
			@ApiParam(name="pageNum",value="页码，从1开始，默认为1",required=true)
			@RequestParam(value="pageNum",defaultValue="1")
			Integer pageNum,
			@ApiParam(name="pageSize",value="每页大小，默认为10",required=true)
			@RequestParam(value="pageSize",defaultValue="10")
			Integer pageSize,
			@ApiParam(name="orderBy",value="排序字段 ，‘order desc’",required=false)
			@RequestParam(value="orderBy",required=false)
			String orderBy,
			@ApiParam(name="proCompanyUser",value="根据需要传递相应参数",required=false)
			ProCompanyUser proCompanyUser){
		try {
			Page<Map<String,String>> page = personalQualificationService.getPage(pageNum, pageSize, orderBy,proCompanyUser);
			return Result.failure(ResultCode.SUCCESS, page.toPageInfo());
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			e.printStackTrace();
		}
		return Result.failure(ResultCode.SYSTEM_INNER_ERROR);
	}
    
    @ApiOperation(value="获取所有个人信息", notes="获取所有个人信息")
	@GetMapping(value = "/getUserList")
	public Result getUserList(ProCompanyUser proCompanyUser){
		try {
			List<Map<String,String>> list = personalQualificationService.getUserList(proCompanyUser);
			return Result.failure(ResultCode.SUCCESS, list);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			e.printStackTrace();
		}
		return Result.failure(ResultCode.SYSTEM_INNER_ERROR);
	}
    
    /**
     * 添加施工人员与资质证书
     * @param proCompanyUser
     * @return
     */
    @ApiOperation(value="添加施工人员与资质证书", notes="添加施工人员与资质证书")
	@PutMapping(value = "/addCpUser")
	public Result addCpUser(
			@ApiParam(name="proPertificate",value="多个资质信息数组",required=true)
			String proPertificate, 
			ProCompanyUser proCompanyUser,
			@ApiParam(name="userAccount",value="用户账号",required=true)
			@RequestParam(value="userAccount",required=true)
			String userAccount,@CurrentUser BaseUser baseUser){
    	try {
    		List<ProPertificate> listproPertificates = JSONObject.parseArray(proPertificate, ProPertificate.class);
    		Integer it = personalQualificationService.addCpUser(proCompanyUser,listproPertificates,userAccount,baseUser.getTenantId());
    		if(it==1){
    			return Result.success();
    		}else{
    			return Result.failure(ResultCode.DATA_IS_WRONG);
    		}
		} catch (Exception e) {
		}
		return Result.failure(ResultCode.SYSTEM_INNER_ERROR);
	}
    
    
    /**
     * 修改施工人员关联
     * @param proCompanyUser
     * @return
     */
    /*@ApiOperation(value="修改施工人员关联", notes="修改施工人员关联")
    @PostMapping(value = "/updateCpUser")
	public Result updateCpUser(ProCompanyUser proCompanyUser){
    	try {
    		Integer it = personalQualificationService.updateCpUser(proCompanyUser);
    		if(it==1){
    			return Result.success();
    		}else{
    			return Result.failure(ResultCode.DATA_IS_WRONG);
    		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Result.failure(ResultCode.SYSTEM_INNER_ERROR);
	}*/
    
    /**
     * 删除施工人员关联
     * @param comqId
     * @param userId
     * @return
     */
    @ApiOperation(value="删除个人资质", notes="删除个人资质")
	@DeleteMapping(value = "/delProPertificate")
	public Result delProPertificate(
			@ApiParam(name="certificateId",value="个人资质id",required=true)
	        @RequestParam(value="certificateId",required=true)
	        String certificateId){
    	try {
    		Integer it = personalQualificationService.delProPertificateByCertificateId(certificateId);
    		if(it>=0){
    			return Result.success();
    		}else{
    			return Result.failure(ResultCode.DATA_IS_WRONG);
    		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Result.failure(ResultCode.SYSTEM_INNER_ERROR);
	}
    
	/**
	 * @Description: 用户根据输入的姓名查询对应用户的信息
	 * @param userNameAndPinyin 用户姓名或者输入首字母
	 * @return 
	 * @author liuhaihe
     * @date 2019年2月28日
	 */
	@ApiOperation(value="姓名查询用户信息", notes="用户根据输入的姓名查询对应用户的信息")
	@GetMapping(path="/getList")
	public Result selectPersonalQualificationByUserName(
			@ApiParam(name="userNameAndPinyin",value="用户姓名或者输入首字母",required=true)
			String userNameAndPinyin){
		LOGGER.info("参数为:"+userNameAndPinyin);
		
 		try {
			if (userNameAndPinyin.matches("[a-zA-Z]+")) {
				userNameAndPinyin = userNameAndPinyin.toLowerCase();
			}
			Map<String,String> userLists = personalQualificationService.getList(userNameAndPinyin);
			if (userLists != null) {
    			return Result.failure(ResultCode.SUCCESS, userLists);
    		} else {
    			return Result.failure(ResultCode.RESULE_DATA_NONE);
    		}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return Result.failure(ResultCode.SYSTEM_INNER_ERROR);
	}
	
	/**
	 * @Description: 获取用户id查询对应用户的信息
	 * @param userId 用户id
	 * @return 
	 * @author liuhaihe
     * @date 2019年2月28日
	 */
	@ApiOperation(value="id查询用户信息", notes="获取用户id查询对应用户的信息")
	@GetMapping(path="/getUserinfo")
	public Result selectPersonalQualificationByUserId(
			@ApiParam(name="userId",value="用户id",required=true)
			@RequestParam
			String userId){
		LOGGER.info("参数为:"+userId);
		try {
			SysUserVo sysUserVo = personalQualificationService.getUserinfo(userId);
			if (sysUserVo != null) {
    			return Result.failure(ResultCode.SUCCESS, sysUserVo);
    		} else {
    			return Result.failure(ResultCode.RESULE_DATA_NONE);
    		}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return Result.failure(ResultCode.SYSTEM_INNER_ERROR);
	}
	
	/**
	 * @Description:  更新人员的信息
	 * @param userId 用户id
	 * @return 
	 * @author liuhaihe
     * @date 2019年2月28日
	 */
	@ApiOperation(value="更新人员信息", notes="获取用户id更新对应人员的信息")
	@PutMapping(path="/saveUserinfo")
	public Result savePersonalQualificationByUserId(
			UserInfoVo userInfoVo){
		LOGGER.info("参数为:"+userInfoVo);
		try {
			Integer t = personalQualificationService.saveUserinfo(userInfoVo);
			if (t > 0) {
    			return Result.success();
    		} else {
    			return Result.failure(ResultCode.RESULE_DATA_NONE);
    		}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return Result.failure(ResultCode.SYSTEM_INNER_ERROR);
	}
	
	/**
	 * @Description:  添加人员的信息
	 * @param UserInfoVo 封装人员信息
	 * @return 
	 * @author liuhaihe
     * @date 2019年2月28日
	 */
	@ApiOperation(value="增加人员信息", notes="获取实体对象增加人员的信息")
	@PostMapping(path="/addUserinfo")
	public Result addPersonalQualification(
			UserInfoVo UserInfoVo){
		LOGGER.info("参数为:"+UserInfoVo.getAvatarUrl());
		try {
			Integer t = personalQualificationService.saveUserinfo(UserInfoVo);
	  	    if (t > 0) {
    			return Result.success();
    		} else {
    			return Result.failure(ResultCode.RESULE_DATA_NONE);
    		}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return Result.failure(ResultCode.SYSTEM_INNER_ERROR);
	}
	
	/**
	 * @Description: 添加个人的资质信息
	 * @param userId 用户id
	 * @param ProPertificate 资质信息
	 * @return 
	 * @author liuhaihe
     * @date 2019年2月28日
	 */
	@ApiOperation(value="增加个人资质信息", notes="获取实体对象增加个人的资质信息")
	@PostMapping(path="/addProPertificate")
	public Result addPersonalQualificationByUserId(
			ProPertificate proPertificate, 
			@ApiParam(name="userId",value="用户id",required=true)
			String userId){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		LOGGER.info("参数为:"+proPertificate.getStringEffectiveDate());
		LOGGER.info("增加个人资质用户id为:"+userId);
		try {
			if (StringUtils.isNotBlank(proPertificate.getStringEffectiveDate())) {
				Date effectiveDate = dateFormat.parse(proPertificate.getStringEffectiveDate());
				proPertificate.setEffectiveDate(effectiveDate);
			}
			Integer t = personalQualificationService.addProPertificate(proPertificate,userId);
	  	    if (t > 0) {
    			return Result.success();
    		} else {
    			return Result.failure(ResultCode.RESULE_DATA_NONE);
    		}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return Result.failure(ResultCode.SYSTEM_INNER_ERROR);
	}
	
	/**
	 * @Description: 通讯录中用户查询
	 * * @param certificateId 资质id
	 * @author liuhaihe
     * @date 2019年2月28日
	 */
	@ApiOperation(value="查询通讯录", notes="查询所有用户到通讯录")
	@GetMapping(path="/allUserinfo")
	public Result allUserPersonalQualificationInfo(){
		try {
			Map<String,List<UserInfoVo>>  sysUserLists = personalQualificationService.allUserinfo();
			if (sysUserLists.size() > 0) {
				return Result.failure(ResultCode.SUCCESS, sysUserLists);
    		} else {
    			return Result.failure(ResultCode.RESULE_DATA_NONE);
    		}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return Result.failure(ResultCode.SYSTEM_INNER_ERROR);
	}
	
	/**
	 * @Description: 个人信息中的资质信息查看明细
	 * @return 
	 * @author liuhaihe
     * @date 2019年2月28日
	 */
	@ApiOperation(value="查看明细", notes="查看个人信息资质明细")
	@GetMapping(path="/getQuaInfo")
	public Result getPersonalQualificationInfo(
			@ApiParam(name="certificateId",value="资质信息id",required=true)
			@RequestParam(value="certificateId",required=true)
			String certificateId){
		try {
			LOGGER.info("查看个人资质详情的资质信息id为:"+certificateId);
			ProPertificate  personalInfo = personalQualificationService.getPersonalQualificationInfo(certificateId);
			if (personalInfo != null) {
				return Result.failure(ResultCode.SUCCESS, personalInfo);
    		} else {
    			return Result.failure(ResultCode.RESULE_DATA_NONE);
    		}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return Result.failure(ResultCode.SYSTEM_INNER_ERROR);
	}
	
	/**
	 * @Description: 删除个人信息与资质信息
	 * @return 
     * @date 2019年2月28日
	 */
	@ApiOperation(value="删除个人信息与资质信息", notes="删除个人信息与资质信息")
	@PostMapping(path="/delQuaInfo")
	public Result delPersonalQualificationInfo(
			@ApiParam(name="comqId",value="施工单位id",required=true)
			@RequestParam(value="comqId",required=true)
			String comqId,
			@ApiParam(name="userId",value="施工人员id",required=true)
			@RequestParam(value="userId",required=true)
			String userId){
		try {
			Boolean flag = personalQualificationService.delPersonalQualificationInfo(comqId,userId);
			if (flag == true) {
				return Result.success();
    		} else {
    			return Result.failure(ResultCode.ERROR);
    		}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return Result.failure(ResultCode.SYSTEM_INNER_ERROR);
	}
	
	
	
	/**
	 * @Description: 修改个人的资质信息
	 * @param userId 用户id
	 * @param ProPertificate 资质信息
	 * @return 
	 * @author liuhaihe
     * @date 2019年6月27日
	 */
	@ApiOperation(value="修改个人资质信息", notes="获取实体对象修改个人的资质信息")
	@PostMapping(path="/saveProPertificate")
	public Result savePersonalQualification(
			ProPertificate proPertificate, 
			@ApiParam(name="certificateId",value="资质信息id",required=true)
			@RequestParam String certificateId){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		LOGGER.info("参数为:"+proPertificate.getStringEffectiveDate());
		LOGGER.info("增加个人资质信息id为:"+certificateId);
		try {
			if (StringUtils.isNotBlank(proPertificate.getStringEffectiveDate())) {
				Date effectiveDate = dateFormat.parse(proPertificate.getStringEffectiveDate());
				proPertificate.setEffectiveDate(effectiveDate);
			}
			Integer t = personalQualificationService.saveProPertificate(proPertificate,certificateId);
	  	    if (t > 0) {
    			return Result.success();
    		} else {
    			return Result.failure(ResultCode.RESULE_DATA_NONE);
    		}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return Result.failure(ResultCode.SYSTEM_INNER_ERROR);
	}

}
