package com.cmcc.know.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cmcc.common.bean.Result;
import com.cmcc.common.bean.ResultCode;
import com.cmcc.know.entity.Knowledge;
import com.cmcc.know.service.KnowledgeService;
import com.github.pagehelper.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 
 * ClassName: KnowledgeController 
 * @Description: TODO 资料库控制类
 * @author zengzhibin
 * @date 2019年2月27日
 */
@Api(value="资料库接口")
@RestController
@RequestMapping("/knowledge")
public class KnowledgeController {
	
	private Logger log =  LoggerFactory.getLogger(this.getClass());
	
	/**
	 * 资料库业务实现类
	 */
    @Autowired
    private KnowledgeService knowledgeService;
    
    
    /**
     * 
     * @Description: TODO 分页带条件查询资料库
     * @param pageNum 页码 从1开始
     * @param pageSize 每页大小
     * @param orderBy 排序
     * @param hnowledge 条件查询实体
     * @return Result  
     * @author zengzhibin
     * @date 2019年2月27日
     */
    @ApiOperation(value="分页获取资料库", notes="分页带条件查询资料库")
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
			Knowledge hnowledge){
		try {
			Page<Knowledge> page = knowledgeService.getPage(pageNum, pageSize, orderBy, hnowledge);
			return Result.failure(ResultCode.SUCCESS, page.toPageInfo());
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		return Result.failure(ResultCode.SYSTEM_INNER_ERROR);
	}
    
    /**
     * 
     * @Description: TODO 根据ID获取资料库
     * @param hnowId
     * @return Result  
     * @author zengzhibin
     * @date 2019年3月5日
     */
    @ApiOperation(value="根据ID获取资料库", notes="根据ID获取资料库")
    @GetMapping(value = "/{hnowId}")
	public Result getKnowLedge(
			@ApiParam(name="hnowId",value="资料库ID",required=true)
			@PathVariable String hnowId){
    	try {
    		Knowledge hnowledge = knowledgeService.getKnowLedge(hnowId);
    		if(hnowledge!=null){
    			return Result.success(hnowledge);
    		}else{
    			return Result.failure(ResultCode.RESULE_DATA_NONE);
    		}
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		return Result.failure(ResultCode.SYSTEM_INNER_ERROR);
	}
    
    /**
     * 
     * @Description: TODO 添加资料库
     * @param hnowledge 资料库实体
     * @return Result  
     * @author zengzhibin
     * @date 2019年2月27日
     */
    @ApiOperation(value="添加资料库", notes="根据实体添加资料库")
	@PutMapping
	public Result addKnowLedge(Knowledge hnowledge){
    	try {
    		Integer it = knowledgeService.add(hnowledge);
    		if(it==1){
    			return Result.success();
    		}else{
    			return Result.failure(ResultCode.DATA_IS_WRONG);
    		}
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		return Result.failure(ResultCode.SYSTEM_INNER_ERROR);
	}
    
    
    /**
     * 
     * @Description: TODO 根据实体ID更新资料库
     * @param hnowId 资料ID
     * @param hnowledge 资料实体
     * @return Result  
     * @author zengzhibin
     * @date 2019年2月27日
     */
    @ApiOperation(value="更新资料库", notes="根据实体ID更新资料库")
	@PostMapping("/{hnowId}")
	public Result updateKnowLedge(
			@ApiParam(name="hnowId",value="资料库ID",required=true)
			@PathVariable String hnowId,
			Knowledge hnowledge){
    	try {
    		hnowledge.setHnowId(hnowId);
    		Integer it = knowledgeService.update(hnowledge);
    		if(it==1){
    			return Result.success();
    		}else{
    			return Result.failure(ResultCode.RESULE_DATA_NONE);
    		}
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		return Result.failure(ResultCode.SYSTEM_INNER_ERROR);
	}
    
    
    /**
     * 
     * @Description: TODO 根据ID逻辑删除资料库
     * @param hnowId 资料ID
     * @return Result  
     * @author zengzhibin
     * @date 2019年2月27日
     */
    @ApiOperation(value="删除资料库", notes="根据ID逻辑删除资料库")
	@DeleteMapping("/{hnowId}")
	public Result delKnowLedge(
			@ApiParam(name="hnowId",value="资料库ID",required=true)
			@PathVariable String hnowId){
    	try {
    		Integer it = knowledgeService.delete(hnowId);
    		if(it==1){
    			return Result.success();
    		}else{
    			return Result.failure(ResultCode.RESULE_DATA_NONE);
    		}
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		return Result.failure(ResultCode.SYSTEM_INNER_ERROR);
	}
    
    
    
}
