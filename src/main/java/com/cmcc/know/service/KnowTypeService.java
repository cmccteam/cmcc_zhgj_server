package com.cmcc.know.service;

import java.util.List;

import com.cmcc.know.entity.KnowType;

/**
 * 
 * ClassName: KnowTypeService 
 * @Description: TODO 资料类型业务接口
 * @author zengzhibin
 * @date 2019年2月27日
 */
public interface KnowTypeService {
	
	
	/**
	 * 
	 * @Description: TODO 添加资料类型
	 * @param knowType 资料类型实体
	 * @return Integer 1成功 0失败 
	 * @author zengzhibin
	 * @date 2019年2月27日
	 */
	public Integer add(KnowType knowType);
	
	/**
	 * 
	 * @Description: TODO 更新资料类型
	 * @param knowType 资料类型实体
	 * @return Integer 1成功 0失败  
	 * @author zengzhibin
	 * @date 2019年2月27日
	 */
	public Integer update(KnowType knowType);
	
	/**
	 * 
	 * @Description: TODO 删除资料类型
	 * @param hnowId 资料类型ID
	 * @return Integer  1成功 0失败  
	 * @author zengzhibin
	 * @date 2019年2月27日
	 */
	public Integer delete(String typeId);

	/**
	 * 
	 * @Description: TODO 获取所有资料类型
	 * @return List<KnowType>  
	 * @author zengzhibin
	 * @date 2019年3月1日
	 */
	public List<KnowType> getAll();
	
	
}
