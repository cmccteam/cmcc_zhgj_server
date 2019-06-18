package com.cmcc.common.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cmcc.common.bean.Result;
import com.cmcc.common.bean.ResultCode;
import com.cmcc.common.service.FileStoreService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value="文件库接口")
@RestController
@RequestMapping("/fileStore")
public class FileStoreController {

	private Logger log =  LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private FileStoreService fileStoreService;
	
	/**
     * 
     * @Description: TODO 上传文件
     * @param file 附件
     * @return Result  
     * @author zengzhibin
     * @date 2019年2月27日
     */
    @ApiOperation(value="上传文件", notes="上传文件")
    @PostMapping("/upload")
	public Result uploadFile(
			@ApiParam(name="file",value="文件",required=true)
			@RequestParam("file") MultipartFile file,HttpServletRequest request){
    	try {
    		// 判断文件是否为空
            if (file.isEmpty()) {
                return Result.failure(ResultCode.PARAM_NOT_COMPLETE, "");
            }
			return fileStoreService.uploadFile(file,request);
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		return Result.failure(ResultCode.SYSTEM_INNER_ERROR);
	}
    
  /*  @ApiOperation(value="下载", notes="下载")
    @GetMapping("/download/{fileId}")
    public void download(@PathVariable("fileName") String fileName, HttpServletResponse res) {
    }
    
    @ApiOperation(value="在线浏览", notes="在线浏览")
    @GetMapping("/view/{fileId}")
    public ResponseEntity<InputStreamResource> view(@PathVariable("fileId") String fileId){
    	return null;
    }*/
 
    /**
     * 文件列表查询
     */
 
    /**
     * 逻辑删除文件
     */
    
}
