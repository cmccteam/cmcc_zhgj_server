package com.cmcc.know.service;

import com.cmcc.know.entity.KnowType;

import java.util.List;

/**
 * ClassName: KnowTypeService
 *
 * @author zengzhibin
 * @Description: TODO 资料类型业务接口
 * @date 2019年2月27日
 */
public interface KnowTypeService {


    /**
     * @param knowType 资料类型实体
     * @return Integer 1成功 0失败
     * @Description: TODO 添加资料类型
     * @author zengzhibin
     * @date 2019年2月27日
     */
    public Integer add(KnowType knowType);

    /**
     * @param knowType 资料类型实体
     * @return Integer 1成功 0失败
     * @Description: TODO 更新资料类型
     * @author zengzhibin
     * @date 2019年2月27日
     */
    public Integer update(KnowType knowType);

    /**
     * @param typeId 资料类型ID
     * @return Integer  1成功 0失败
     * @Description: TODO 删除资料类型
     * @author zengzhibin
     * @date 2019年2月27日
     */
    public Integer delete(String typeId);

    /**
     * @return List<KnowType>
     * @Description: TODO 获取所有资料类型
     * @author zengzhibin
     * @date 2019年3月1日
     */
    public List<KnowType> getAll();


}
