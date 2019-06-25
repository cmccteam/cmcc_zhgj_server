package com.cmcc.exam.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author zwq
 * @create 2019-06-24 15:52
 */
@ApiModel(value = "交卷请求参数")
public class SubmitPaperResultRequest {
    @ApiModelProperty(value = "题目ID", name = "libPaperId", required = true)
    private String libPaperId;
    @ApiModelProperty(value = "题目结果", name = "libResult", required = true, position = 1)
    private String libResult;

    public String getLibPaperId() {
        return libPaperId;
    }

    public void setLibPaperId(String libPaperId) {
        this.libPaperId = libPaperId;
    }

    public String getLibResult() {
        return libResult;
    }

    public void setLibResult(String libResult) {
        this.libResult = libResult;
    }
}
