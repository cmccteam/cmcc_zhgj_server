package com.cmcc.qualification.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;


import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cmcc.common.bean.Result;
import com.cmcc.common.bean.ResultCode;
import com.cmcc.qualification.entity.ProPertificate;
import com.cmcc.qualification.service.PersonalQualificationService;
import com.cmcc.qualification.vo.SysUserVo;
import com.cmcc.qualification.vo.UserInfoVo;

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
	@ApiOperation(value="id查询用户信息", notes="获取用户id查询对应用户的信息,可能有多条，暂时取第一条展示")
	@GetMapping(path="/getUserinfo")
	public Result selectPersonalQualificationByUserId(
			@ApiParam(name="userId",value="用户id",required=true)
			String userId){
		LOGGER.info("参数为:"+userId);
		try {
			SysUserVo sysUserVo = personalQualificationService.getUserinfo(userId);
			if (sysUserVo.getSysUser() != null) {
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
			String certificateId){
		try {
			LOGGER.info("查看个人资质详情的资质信息id为:"+certificateId);
			Map<String,String>  personalInfo = personalQualificationService.getPersonalQualificationInfo(certificateId);
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
	 * @Description: 删除个人资质信息
	 * @return 
	 * @author liuhaihe
     * @date 2019年2月28日
	 */
	@ApiOperation(value="删除个人资质", notes="根据资质信息id删除个人信息资质")
	@PostMapping(path="/delQuaInfo")
	public Result delPersonalQualificationInfo(
			@ApiParam(name="certificateId",value="资质信息id",required=true)
			String certificateId){
		try {
			LOGGER.info("删除个人资质的资质信息id为:"+certificateId);
			Boolean flag = personalQualificationService.delPersonalQualificationInfo(certificateId);
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
	 * @Description: 导入添加个人资质
	 * @return 
	 * @author liuhaihe
     * @date 2019年2月28日
	 */
	@ApiOperation(value="导入添加", notes="导入添加个人资质")
	@GetMapping(path="/importUsers")
	public Result importUsers(@RequestParam("file") MultipartFile file){
		try {
	        String fileName = file.getOriginalFilename();
			Boolean  flag = personalQualificationService.batchImportUsers(fileName, file);
			if (flag) {
				return Result.success();
    		} else {
    			return Result.failure(ResultCode.ERROR);
    		}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return Result.failure(ResultCode.SYSTEM_INNER_ERROR);
	}
	


}
