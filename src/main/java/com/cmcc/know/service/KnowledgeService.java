package com.cmcc.know.service;

import java.util.Map;

import com.cmcc.know.entity.Knowledge;
import com.github.pagehelper.Page;

/**
 * 
 * ClassName: KnowledgeService 
 * @Description: TODO 资料库业务接口
 * @author zengzhibin
 * @date 2019年2月27日
 */
public interface KnowledgeService {
	
	/**
	 * 
	 * @Description: TODO 带条件分页获取资料库数据
	 * @param pageNum 页码从1开始
	 * @param pageSize 每页大小
	 * @param orderBy 排序字段
	 * @param hnowledge 条件查询对象
	 * @return Page<Knowledge>  
	 * @author zengzhibin
	 * @date 2019年2月27日
	 */
	public Page<Knowledge> getPage(Integer pageNum, Integer pageSize, String orderBy, Knowledge hnowledge);
	
	/**
	 * 
	 * @Description: TODO 添加资料库
	 * @param hnowledge 资料库实体
	 * @return Integer 1成功 0失败 
	 * @author zengzhibin
	 * @date 2019年2月27日
	 */
	public Integer add(Knowledge hnowledge);
	
	/**
	 * 
	 * @Description: TODO 更新资料库
	 * @param hnowledge 资料库实体
	 * @return Integer 1成功 0失败  
	 * @author zengzhibin
	 * @date 2019年2月27日
	 */
	public Integer update(Knowledge hnowledge);
	
	/**
	 * 
	 * @Description: TODO 删除资料库
	 * @param hnowId 资料库ID
	 * @return Integer  1成功 0失败  
	 * @author zengzhibin
	 * @date 2019年2月27日
	 */
	public Integer delete(String hnowId);

	/**
	 * 
	 * @Description: TODO 根据ID获取资料库
	 * @param hnowId
	 * @return Knowledge  
	 * @author zengzhibin
	 * @date 2019年3月5日
	 */
	public Knowledge getKnowLedge(String hnowId);
	
	
}
