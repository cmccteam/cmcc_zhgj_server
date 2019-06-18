package com.cmcc.exam.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cmcc.common.bean.Result;
import com.cmcc.common.bean.ResultCode;
import com.cmcc.exam.entity.ExamLibUser;
import com.cmcc.exam.entity.ExamPaper;
import com.cmcc.exam.service.ExamMainService;
import com.github.pagehelper.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 
 * ClassName: ExamMainController 
 * @Description: TODO 知识竞赛控制类
 * @author zengzhibin
 * @date 2019年2月28日
 */

@Api(value="知识竞赛接口")
@RestController
@RequestMapping("/exam")
public class ExamMainController {

	private Logger log =  LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ExamMainService examMainService;
	/**
	 * 
	 * @Description: TODO 分页获取试卷数据
	  * @param pageNum 页码 从1开始
     * @param pageSize 每页大小
     * @param orderBy 排序
	 * @param title 试卷名称
	 * @return Result  
	 * @author zengzhibin
	 * @date 2019年2月28日
	 */
	/*@ApiOperation(value="分页获取试卷数据", notes="分页带条件查询试卷数据")
	@GetMapping("/getPaperPage")
	public Result getExamPaperPage(
			@ApiParam(name="pageNum",value="页码，从1开始，默认为1",required=true)
			@RequestParam(value="pageNum",defaultValue="1")
			Integer pageNum,
			@ApiParam(name="pageSize",value="每页大小，默认为10",required=true)
			@RequestParam(value="pageSize",defaultValue="10")
			Integer pageSize,
			@ApiParam(name="orderBy",value="排序字段 ，‘order desc’",required=false)
			@RequestParam(value="orderBy",required=false)
			String orderBy,
			@ApiParam(name="title",value="试卷名称",required=false)
			@RequestParam(value="title",required=false)
			String title,
			@ApiParam(name="userId",value="用户ID",required=false)
			@RequestParam(value="userId",required=false)
			String userId){
		try {
			Page<ExamPaper> page = examMainService.getExamPaperPage(pageNum, pageSize, orderBy, title,userId);
			return Result.failure(ResultCode.SUCCESS, page.toPageInfo());
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		return Result.failure(ResultCode.SYSTEM_INNER_ERROR);
	}*/
	
	
	/**
	 * 
	 * @Description: TODO 分页获取试卷数据
	  * @param pageNum 页码 从1开始
     * @param pageSize 每页大小
     * @param orderBy 排序
	 * @param title 试卷名称
	 * @return Result  
	 * @author zengzhibin
	 * @date 2019年2月28日
	 */
	@ApiOperation(value="分页获取试卷数据", notes="分页带条件查询试卷数据")
	@GetMapping("/getPaperPage")
	public Result getExamPaperPage(
			@ApiParam(name="pageNum",value="页码，从1开始，默认为1",required=true)
			@RequestParam(value="pageNum",defaultValue="1")
			Integer pageNum,
			@ApiParam(name="pageSize",value="每页大小，默认为10",required=true)
			@RequestParam(value="pageSize",defaultValue="10")
			Integer pageSize,
			@ApiParam(name="orderBy",value="排序字段 ，‘order desc’",required=false)
			@RequestParam(value="orderBy",required=false)
			String orderBy,
			@ApiParam(name="title",value="试卷名称",required=false)
			@RequestParam(value="title",required=false)
			String title,
			@ApiParam(name="userId",value="用户ID",required=false)
			@RequestParam(value="userId",required=false)
			String userId){
		try {
			Page<Map<String,Object>> page = examMainService.getMyExamPaperPage(pageNum, pageSize, orderBy, title,userId);
			return Result.failure(ResultCode.SUCCESS, page.toPageInfo());
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		return Result.failure(ResultCode.SYSTEM_INNER_ERROR);
	}
	
	/**
	 * 
	 * @Description: TODO 更新、发布试卷
	 * @param examPaper
	 * @return Result  
	 * @author zengzhibin
	 * @date 2019年2月28日
	 */
	@ApiOperation(value="添加试卷", notes="添加试卷")
	@PutMapping("/paper")
	public Result addExamPaper(ExamPaper examPaper){
    	try {
    		Integer it = examMainService.add(examPaper);
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
	 * @Description: TODO 更新、发布试卷
	 * @param examPaper
	 * @return Result  
	 * @author zengzhibin
	 * @date 2019年2月28日
	 */
	@ApiOperation(value="更新试卷", notes="根据实体ID更新试卷")
	@PostMapping("/paper/{paperId}")
	public Result updateExamPaper(
			@ApiParam(name="paperId",value="试卷ID",required=true)
			@PathVariable String paperId,
			ExamPaper examPaper){
		
		try {
			examPaper.setPaperId(paperId);
    		Integer it = examMainService.update(examPaper);
    		if(it==1){
    			return Result.success();
    		}else{
    			return Result.failure(ResultCode.DATA_NOT_UPDATE);
    		}
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		return Result.failure(ResultCode.SYSTEM_INNER_ERROR);
	}
	
	/**
	 * 
	 * @Description: TODO 删除试卷
	 * @param paperId 试卷ID
	 * @return Result  
	 * @author zengzhibin
	 * @date 2019年2月28日
	 */
	@ApiOperation(value="删除试卷", notes="根据ID删除试卷")
	@DeleteMapping("/paper/{paperId}")
	public Result deleteExamPaper(
			@ApiParam(name="paperId",value="试卷ID",required=true)
			@PathVariable String paperId){
    	try {
    		Integer it = examMainService.delete(paperId);
    		if(it==1){
    			return Result.success();
    		}else{
    			return Result.failure(ResultCode.DATA_NOT_DEL);
    		}
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		return Result.failure(ResultCode.SYSTEM_INNER_ERROR);
	}
	
	/**
	 * 
	 * @Description: TODO 导入题库
	 * @param file
	 * @param request
	 * @return Result  
	 * @author zengzhibin
	 * @date 2019年2月28日
	 */
	@ApiOperation(value="导入题库", notes="导入题库")
    @PostMapping("/importLib")
	public Result importLib(
			@ApiParam(name="file",value="文件模板",required=true)
			@RequestParam("file") MultipartFile file, HttpServletRequest request){
		try {
			return examMainService.importLib(file);
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		return Result.failure(ResultCode.SYSTEM_INNER_ERROR);
	}
	
	/**
	 * 
	 * @Description: TODO 获取试卷参题目与竞赛
	 * @param userId
	 * @param paperId
	 * @return Result  
	 * @author zengzhibin
	 * @date 2019年2月28日
	 */
	@ApiOperation(value="获取试卷参题目与竞赛", notes="获取试卷参题目与竞赛")
    @PostMapping("/takePart")
	public Result takePart(
			@ApiParam(name="userId",value="用户ID",required=true)
			@RequestParam(value="userId",required=true)
			String userId,
			@ApiParam(name="paperId",value="试卷ID",required=true)
			@RequestParam(value="paperId",required=true)
			String paperId,
			@ApiParam(name="tmType",value="1上一题，2下一题,3提交试卷完成",required=true)
			@RequestParam(value="tmType",required=true)
			Integer tmType,
			/*@ApiParam(name="index",value="当前是第几题",required=false)
			@RequestParam(value="index",defaultValue="0")
			Integer index,*/
			ExamLibUser examLibUser){
		try {
			Map<String, Object> map = examMainService.takePart(userId,paperId,tmType,0,examLibUser);
			if(map.isEmpty()){
				return Result.failure(ResultCode.RESULE_DATA_NONE, map);
			}
			return Result.failure(ResultCode.SUCCESS, map);
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		return Result.failure(ResultCode.SYSTEM_INNER_ERROR);
	}
	/**
	 * 
	 * @Description: TODO 获取在线竞赛的积分排行榜
	 * @return Result  
	 * @author zengzhibin
	 * @date 2019年2月28日
	 */
	@ApiOperation(value="获取在线竞赛的积分排行榜", notes="获取在线竞赛的积分排行榜")
    @GetMapping("/getIntRank/{rows}")
	public Result getIntRank(
			@ApiParam(name="rows",value="排行榜展示数量 ",required=true)
			@PathVariable Integer rows){
		try {
			List<Map<String,String>> list = examMainService.getIntRank(rows);
    		return Result.failure(ResultCode.SUCCESS, list);
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		return Result.failure(ResultCode.SYSTEM_INNER_ERROR);
	}
}
