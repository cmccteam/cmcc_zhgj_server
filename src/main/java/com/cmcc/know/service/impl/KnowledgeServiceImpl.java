package com.cmcc.know.service.impl;

import com.cmcc.common.utils.IdGenerateUtil;
import com.cmcc.know.dao.KnowledgeDao;
import com.cmcc.know.entity.Knowledge;
import com.cmcc.know.service.KnowledgeService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName: KnowledgeServiceImpl
 *
 * @author zengzhibin
 * @Description: TODO 资料库业务实现类
 * @date 2019年2月27日
 */
@Service
public class KnowledgeServiceImpl implements KnowledgeService {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private KnowledgeDao knowledgeDao;

    @Override
    public Page<Knowledge> getPage(Integer pageNum, Integer pageSize, String orderBy, Knowledge hnowledge) {
        PageHelper.startPage(pageNum, pageSize, orderBy);
        return knowledgeDao.selectPage(hnowledge);
    }

    @Override
    public Integer add(Knowledge hnowledge) {
        hnowledge.setHnowId(IdGenerateUtil.uuid3());
        return knowledgeDao.insertSelective(hnowledge);
    }

    @Override
    public Integer update(Knowledge hnowledge) {
        return knowledgeDao.updateByPrimaryKeySelective(hnowledge);
    }

    @Override
    public Integer delete(String hnowId) {
        return knowledgeDao.deleteByPrimaryKey(hnowId);
    }

    @Override
    public Knowledge getKnowLedge(String hnowId) {
        return knowledgeDao.selectByPrimaryKey(hnowId);
    }

}
