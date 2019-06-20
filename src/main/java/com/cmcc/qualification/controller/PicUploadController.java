package com.cmcc.qualification.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cmcc.common.bean.Result;
import com.cmcc.common.bean.ResultCode;
import com.cmcc.common.utils.UploadUtils;
import com.cmcc.qualification.service.FileStoreService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * ClassName: PicUploadController 
 * @Description: 图片上传
 * @author liuhaihe
 * @date 2019年3月4日
 */
@Api(value="图片上传接口")
@RestController
@RequestMapping("/picManage")
public class PicUploadController {
	
	private static Logger LOGGER = LoggerFactory.getLogger(CompanyQualificationController.class);
	
	private FileStoreService fileStoreService;
	/**
	 * @Description: 图片上传
	 * @return 
	 * @author liuhaihe
     * @date 2019年2月28日
	 */
	@ApiOperation(value="图片上传", notes="上传图片")
	@PostMapping("/upload")
    public Result upload(MultipartFile fileUpload, HttpServletRequest request,HttpSession session){
        if (fileUpload.isEmpty()) {
        	return Result.failure(ResultCode.PARAM_FILE_IOEX);
        }
		//获取文件名
        String fileName = fileUpload.getOriginalFilename();
        LOGGER.info("获取的文件名"+fileName);
        // 存放上传图片的文件夹
        File fileDir = UploadUtils.getImgDirFile(); 
        // 输出文件夹绝对路径  -- 这里的绝对路径是相当于当前项目的路径而不是“容器”路径 
        System.out.println(fileDir.getAbsolutePath());
        try {
        	// 构建真实的文件路径
        	File newFile = new File(fileDir.getAbsolutePath() + File.separator + fileName); 
        	System.out.println(newFile.getAbsolutePath()); 
        	// 上传图片到 -》 “绝对路径” 
        	fileUpload.transferTo(newFile);
            return Result.success(newFile.getAbsolutePath());
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        } 
        return Result.failure(ResultCode.SYSTEM_INNER_ERROR);
    }
	
	/**
	 * @Description:  删除图片信息
	 * @param userId 图片id
	 * @return 
	 * @author liuhaihe
     * @date 2019年2月28日
	 */
	@ApiOperation(value="删除图片", notes="获取图片id删除相应的图片")
	@PutMapping(path="/delPic")
	public Result delPic(
			@ApiParam(name="fileId",value="图片id",required=true)
			String fileId){
		LOGGER.info("删除图片参数为:"+fileId);
		try {
			Integer t = fileStoreService.delPic(fileId);
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

