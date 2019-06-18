package com.cmcc.common.bean;

import java.util.List;

/** 
 * 树形数据实体接口 
 * @param <E> 
 */  
public interface BaseTree<E> {  
    public String getId();  
    public String getParentId();  
    public void setSelected(Boolean bool); 
    public void setChildList(List<E> childList);  
} 
