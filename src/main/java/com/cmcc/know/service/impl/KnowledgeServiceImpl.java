package com.cmcc.know.service.impl;

import com.cmcc.common.bean.BaseUser;
import com.cmcc.common.utils.IdGenerateUtil;
import com.cmcc.know.dao.KnowledgeDao;
import com.cmcc.know.entity.Knowledge;
import com.cmcc.know.entity.KnowledgeVo;
import com.cmcc.know.service.KnowledgeService;
import com.cmcc.qualification.dao.DaKnowledgeUserDao;
import com.cmcc.qualification.entity.DaKnowledgeUser;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    private DaKnowledgeUserDao knowledgeUserDao;
    
    @Override
    public Page<Knowledge> getPage(Integer pageNum, Integer pageSize, String orderBy, Knowledge hnowledge) {
        PageHelper.startPage(pageNum, pageSize, orderBy);
        return knowledgeDao.selectPage(hnowledge);
    }

    @Override
    public Page<KnowledgeVo> getMyPage(Integer pageNum, Integer pageSize, String orderBy, KnowledgeVo hnowledge,BaseUser baseUser) {
        PageHelper.startPage(pageNum, pageSize, orderBy);
        hnowledge.setMyUserId(baseUser.getUserId());
        return knowledgeDao.selectMyPage(hnowledge);
    }
    
    @Override
    public Integer add(Knowledge hnowledge) {
        hnowledge.setHnowId(IdGenerateUtil.uuid3());
        hnowledge.setCreateTime(new Date());
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

	@Override
	public Integer consultMyHnow(String hnowId, String userId) {
		DaKnowledgeUser record = new DaKnowledgeUser();
		record.setHnowId(hnowId);
		record.setUserId(userId);
		record.setStatus("1");
		record.setCreateTime(new Date());
		return knowledgeUserDao.updateToconsult(record);
	}

	@Transactional
	@Override
	public Integer addKnowUser(String hnowId, String userIds, String userNames) {
		String[] userarray = userIds.split(",");
		String[] namearray = userNames.split(",");
		if(userarray.length==namearray.length){
			for (int i = 0; i < userarray.length; i++) {
				DaKnowledgeUser ku = new DaKnowledgeUser();
				ku.setId(IdGenerateUtil.uuid3());
				ku.setHnowId(hnowId);
				ku.setStatus("0");
				ku.setUserId(userarray[i]);
				ku.setUserName(namearray[i]);
				ku.setCreateTime(new Date());
				knowledgeUserDao.insertSelective(ku);
			}
			return 1;
		}else{
			return 0;
		}
		
		
	}

}
