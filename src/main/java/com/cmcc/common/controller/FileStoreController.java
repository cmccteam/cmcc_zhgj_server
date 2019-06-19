package com.cmcc.common.controller;


import com.cmcc.common.bean.Result;
import com.cmcc.common.bean.ResultCode;
import com.cmcc.common.service.FileStoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Api(value = "文件库接口")
@RestController
@RequestMapping("/fileStore")
public class FileStoreController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private FileStoreService fileStoreService;

    @ApiOperation(value = "上传文件", notes = "上传文件")
    @PostMapping("/upload")
    public Result uploadFile(
            @ApiParam(name = "file", value = "文件", required = true)
            @RequestParam("file") MultipartFile file) {
        try {
            // 判断文件是否为空
            if (file.isEmpty()) {
                return Result.failure(ResultCode.PARAM_NOT_COMPLETE, "");
            }
            return fileStoreService.uploadFile(file);
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
        return Result.failure(ResultCode.SYSTEM_INNER_ERROR);
    }

}
