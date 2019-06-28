package com.cmcc.know.service;

import com.cmcc.common.bean.BaseUser;
import com.cmcc.common.bean.Result;
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
     * 资料类型
     *
     * @param knowType
     * @param baseUser
     * @return
     */
    Result add(KnowType knowType, BaseUser baseUser);

    /**
     * 更新资料类型
     *
     * @param knowType
     * @param baseUser
     * @return
     */
    Result update(KnowType knowType, BaseUser baseUser);

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
