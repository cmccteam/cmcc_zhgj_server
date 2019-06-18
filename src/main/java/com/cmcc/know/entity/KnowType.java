package com.cmcc.know.entity;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * ClassName: KnowType 
 * @Description: TODO 资料库类型实体
 * @author zengzhibin
 * @date 2019年3月5日
 */
public class KnowType {
	
	@ApiModelProperty(hidden=true)
    private String typeId;

	@ApiModelProperty(value="类型编码",required=true)
    private String code;

	@ApiModelProperty(value="类型名称",required=true)
    private String typeName;

	@ApiModelProperty(value="父类型ID",required=true)
    private String parentId;

    @ApiModelProperty(hidden=true)
    private Date createTime;

    @ApiModelProperty(hidden=true)
    private String createUser;

    @ApiModelProperty(value="备注",required=false)
    private String remark;

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId == null ? null : typeId.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}