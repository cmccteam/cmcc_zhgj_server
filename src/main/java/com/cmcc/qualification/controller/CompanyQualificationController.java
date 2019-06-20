package com.cmcc.qualification.controller;

import java.util.List;
import java.util.Map;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cmcc.common.bean.Result;
import com.cmcc.common.bean.ResultCode;
import com.cmcc.qualification.entity.ProCompanyQua;
import com.cmcc.qualification.entity.ProPertificate;
import com.cmcc.qualification.service.CompanyQualificationService;
import com.github.pagehelper.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * ClassName: CompanyQualificationController 
 * @Description:  公司资质管理控制层
 * @author liuhaihe
 * @date 2019年2月27日
 */
@Api(value="公司资质管理接口")
@RestController
@RequestMapping("/companyQualification")
public class CompanyQualificationController{
	
	/**
	 * 公司资质管理业务实现类
	 */
	@Autowired
	private CompanyQualificationService companyQualificationService;
	
	
	private static Logger LOGGER = LoggerFactory.getLogger(CompanyQualificationController.class);
	
	/**
	 * @Description: 用户根据输入的信息进行模糊查询返回符合要求的公司名称集合
	 * @param comqNameOrComqPinyin 用户输入公司名称或者公司拼音简写
	 * @param response
	 * @return
	 * @author liuhaihe
     * @date 2019年2月27日
	 */
	@ApiOperation(value="查询公司名称", notes="用户根据输入的信息进行模糊查询返回符合要求的公司名称集合")
	@GetMapping(path="/getList")
	public Result selectAllCompanyQualificationByComqName(
			@ApiParam(name="comqNameOrComqPinyin",value="公司名称或者公司拼音简写",required=true)
			String comqNameOrComqPinyin){
		LOGGER.info("公司查询用户输入信息为:"+comqNameOrComqPinyin);
		try {
			if (comqNameOrComqPinyin.matches("[a-zA-Z]+")) {
				comqNameOrComqPinyin = comqNameOrComqPinyin.toLowerCase();
			}
			List<Map<String,String>> companyLists = companyQualificationService.getList(comqNameOrComqPinyin);
			if (companyLists.size() > 0) {
    			return Result.failure(ResultCode.SUCCESS, companyLists);
    		} else {
    			return Result.failure(ResultCode.RESULE_DATA_NONE);
    		}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return Result.failure(ResultCode.SYSTEM_INNER_ERROR);
	}
	
	/**
	 * @Description: 用户点击确定公司名称时查询对应公司资质信息
	 * @param comqId 公司资质id
	 * @return
	 * @author liuhaihe
     * @date 2019年2月27日
	 */
	@ApiOperation(value="查询公司资质信息", notes="用户点击确定公司名称时查询对应公司资质信息")
	@GetMapping("/getCompanyInfo")
	public Result selectCompanyQualificationByComqId(
			@ApiParam(name="comqId",value="公司资质id",required=true)
	        String comqId
			){
		LOGGER.info("参数为:"+comqId);
		try {
			ProCompanyQua proCompanyQua = companyQualificationService.getCompanyInfo(comqId);
			if (proCompanyQua != null) {
    			return Result.failure(ResultCode.SUCCESS, proCompanyQua);
    		} else {
    			return Result.failure(ResultCode.RESULE_DATA_NONE);
    		}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return Result.failure(ResultCode.SYSTEM_INNER_ERROR);
	} 
	
	/**
     * 
     * @Description: 添加公司资质
     * @param ProCompanyQua 公司信息实体
     * @param ProPertificate 资质信息实体
     * @return Result  
     * @author liuhaihe
     * @date 2019年2月27日
     */
    @ApiOperation(value="添加公司资质", notes="根据实体添加公司资质")
	@PostMapping("/addProCompanyQua")
	public Result addProCompanyQua(ProCompanyQua proCompanyQua,ProPertificate proPertificate){
    	try {
    		Integer it = companyQualificationService.add(proCompanyQua,proPertificate);
    		if(it > 0){
    			return Result.success();
    		}else{
    			return Result.failure(ResultCode.DATA_IS_WRONG);
    		}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return Result.failure(ResultCode.SYSTEM_INNER_ERROR);
	}
    
    /**
     * 
     * @Description: 更新公司资质
     * @param ProCompanyQua 公司信息实体
     * @return Result  
     * @author liuhaihe
     * @date 2019年2月27日
     */
    @ApiOperation(value="更新公司资质", notes="根据实体更新公司资质")
	@PutMapping("/saveProCompanyQua")
	public Result saveProCompanyQua(ProCompanyQua proCompanyQua){
    	try {
 //   		proCompanyQua.setComqId("20190228124621455270");
 //   		proCompanyQua.setComqName("点击撒娇的");
    		Integer it = companyQualificationService.save(proCompanyQua);
    		if(it > 0){
    			return Result.success();
    		}else{
    			return Result.failure(ResultCode.DATA_IS_WRONG);
    		}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return Result.failure(ResultCode.SYSTEM_INNER_ERROR);
	}
    
    /**
     * 
     * @Description: 查询公司列表
     * @return Result  
     * @author liuhaihe
     * @date 2019年3月8日
     */
    @ApiOperation(value="公司列表", notes="查询公司列表")
	@GetMapping("/allProCompanyQuas")
	public Result getAllProCompanyQua(){
    	try {
    		Map<String,List<ProCompanyQua>> proCompanyQuaLists = companyQualificationService.getAllProCompanyQua();
    		if(proCompanyQuaLists.size() > 0){
    			return Result.failure(ResultCode.SUCCESS, proCompanyQuaLists);
    		}else{
    			return Result.failure(ResultCode.DATA_IS_WRONG);
    		}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return Result.failure(ResultCode.SYSTEM_INNER_ERROR);
	}
    
    /**
     * 
     * @Description: 后台管理查询公司列表
     * @return Result  
     * @author liuhaihe
     * @date 2019年6月19日
     */
    @ApiOperation(value="后台管理查询公司列表", notes="后台管理查询公司列表")
	@GetMapping("/allCompanyQuas")
	public Result getAllCompanyQua(
			@ApiParam(name="pageNum",value="页码，从1开始，默认为1",required=true)
	        @RequestParam(value="pageNum",defaultValue="1")
	        Integer pageNum,
	        @ApiParam(name="pageSize",value="每页大小，默认为10",required=true)
	        @RequestParam(value="pageSize",defaultValue="10")
	        Integer pageSize){
    	try {
    		Page<ProCompanyQua> page = companyQualificationService.getProCompanyQua(pageNum,pageSize);
    		if (page.size() > 0) {
    			return Result.success(page.toPageInfo());
    		} else {
    			return Result.failure(ResultCode.RESULE_DATA_NONE);
    		}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return Result.failure(ResultCode.SYSTEM_INNER_ERROR);
	}
	


}
