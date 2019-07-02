package com.cmcc.know.service.impl;

import com.cmcc.common.bean.BaseUser;
import com.cmcc.common.bean.Result;
import com.cmcc.common.bean.ResultCode;
import com.cmcc.common.utils.IdGenerateUtil;
import com.cmcc.know.dao.KnowTypeDao;
import com.cmcc.know.entity.KnowType;
import com.cmcc.know.service.KnowTypeService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * ClassName: KnowledgeServiceImpl
 *
 * @author zengzhibin
 * @Description: TODO 资料库业务实现类
 * @date 2019年2月27日
 */
@Service
public class KnowTypeServiceImpl implements KnowTypeService {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private KnowTypeDao knowTypeDao;

    @Override
    public Result add(KnowType knowType, BaseUser baseUser) {
        if (baseUser == null || StringUtils.isBlank(baseUser.getUserId()))
            return Result.failure(ResultCode.USER_NOT_EXIST);
        knowType.setTypeId(IdGenerateUtil.uuid3());
        knowType.setCreateUser(baseUser.getUserId());
        knowType.setCreateTime(new Date());
        knowTypeDao.insert(knowType);
        return Result.success();
    }

    @Override
    public Result update(KnowType knowType, BaseUser baseUser) {
        if (baseUser == null || StringUtils.isBlank(baseUser.getUserId()))
            return Result.failure(ResultCode.USER_NOT_EXIST);
        knowType.setCreateUser(baseUser.getUserId());
        knowType.setCreateTime(new Date());
        knowTypeDao.updateByPrimaryKey(knowType);
        return Result.success();
    }

    @Override
    public Integer delete(String typeId) {
        return knowTypeDao.deleteByPrimaryKey(typeId);
    }

    @Override
    public List<KnowType> getAll(KnowType knowType) {
        return knowTypeDao.selectAll(knowType);
    }

}
