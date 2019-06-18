package com.cmcc.know.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cmcc.common.bean.Result;
import com.cmcc.common.bean.ResultCode;
import com.cmcc.know.entity.KnowType;
import com.cmcc.know.service.KnowTypeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 
 * ClassName: KnowTypeController 
 * @Description: TODO 资料类型控制类
 * @author zengzhibin
 * @date 2019年2月27日
 */
@Api(value="资料类型接口")
@RestController
@RequestMapping("/knowType")
public class KnowTypeController {
	
	private Logger log =  LoggerFactory.getLogger(this.getClass());
	
	/**
	 * 资料类型库业务实现类
	 */
    @Autowired
    private KnowTypeService knowTypeService;
    
    /**
     * 
     * @Description: TODO 获取资料类型
     * @return Result  
     * @author zengzhibin
     * @date 2019年3月1日
     */
    @ApiOperation(value="获取资料类型", notes="获取所有资料类型")
	@GetMapping
    public Result getAll(){
    	try {
    		List<KnowType> list= knowTypeService.getAll();
    		return Result.failure(ResultCode.SUCCESS, list);
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		return Result.failure(ResultCode.SYSTEM_INNER_ERROR);
    }
    
    /**
     * 
     * @Description: TODO 添加资料类型
     * @param knowType 资料类型实体
     * @return Result  
     * @author zengzhibin
     * @date 2019年2月27日
     */
    @ApiOperation(value="添加资料类型", notes="根据实体添加资料类型")
	@PutMapping
	public Result addKnowType(KnowType knowType){
    	try {
    		Integer it = knowTypeService.add(knowType);
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
     * @Description: TODO 根据实体ID更新资料类型
     * @param hnowId 资料ID
     * @param knowType 资料实体
     * @return Result  
     * @author zengzhibin
     * @date 2019年2月27日
     */
    @ApiOperation(value="更新资料类型", notes="根据实体ID更新资料类型")
	@PostMapping("/{typeId}")
	public Result updateKnowType(
			@ApiParam(name="typeId",value="资料类型ID",required=true)
			@PathVariable String typeId,
			KnowType knowType){
    	try {
    		knowType.setTypeId(typeId);
    		Integer it = knowTypeService.update(knowType);
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
     * @Description: TODO 根据ID逻辑删除资料类型
     * @param hnowId 资料ID
     * @return Result  
     * @author zengzhibin
     * @date 2019年2月27日
     */
    @ApiOperation(value="删除资料类型", notes="根据ID逻辑删除资料类型")
	@DeleteMapping("/{typeId}")
	public Result delKnowType(
			@ApiParam(name="typeId",value="资料类型ID",required=true)
			@PathVariable String typeId){
    	try {
    		Integer it = knowTypeService.delete(typeId);
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
