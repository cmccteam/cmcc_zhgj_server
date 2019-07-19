package com.cmcc.know.entity;

import java.util.Date;
import java.util.TreeSet;

import org.apache.commons.lang3.StringUtils;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * ClassName: KnowType 
 * @Description: TODO 资料库类型实体
 * @author zengzhibin
 * @date 2019年3月5日
 */
public class KnowType implements Comparable<KnowType>{
	
	@ApiModelProperty(hidden=true)
    private String typeId;

	@ApiModelProperty(value="类型编码",required=false)
    private String code;

	@ApiModelProperty(value="类型名称",required=false)
    private String typeName;

	@ApiModelProperty(value="父类型ID",required=false)
    private String parentId;

    @ApiModelProperty(hidden=true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @ApiModelProperty(hidden=true)
    private String createUser;

    @ApiModelProperty(value="备注",required=false)
    private String remark;

    @ApiModelProperty(hidden=true)
    private TreeSet<KnowType> childen;
    
    
    
    public TreeSet<KnowType> getChilden() {
		return childen;
	}

	public void setChilden(TreeSet<KnowType> childen) {
		this.childen = childen;
	}

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

	@Override
	public int compareTo(KnowType arg) {
		return StringUtils.compare(arg.typeId, this.typeId);
	}
}