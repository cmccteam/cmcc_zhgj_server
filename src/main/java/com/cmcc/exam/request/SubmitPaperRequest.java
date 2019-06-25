package com.cmcc.exam.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author zwq
 * @create 2019-06-24 15:31
 */
@ApiModel(value = "交卷请求参数")
public class SubmitPaperRequest {
    @ApiModelProperty(value = "用户ID", name = "userId", required = true)
    private String userId;
    @ApiModelProperty(value = "试卷ID", name = "paperId", required = true)
    private String paperId;
    @ApiModelProperty(value = "题目结果数组", name = "results", required = true)
    private List<SubmitPaperResultRequest> results;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPaperId() {
        return paperId;
    }

    public void setPaperId(String paperId) {
        this.paperId = paperId;
    }

    public List<SubmitPaperResultRequest> getResults() {
        return results;
    }

    public void setResults(List<SubmitPaperResultRequest> results) {
        this.results = results;
    }
}
