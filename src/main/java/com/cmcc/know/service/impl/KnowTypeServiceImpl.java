package com.cmcc.know.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmcc.common.service.UserService;
import com.cmcc.common.utils.IdGenerateUtil;
import com.cmcc.know.dao.KnowTypeDao;
import com.cmcc.know.entity.KnowType;
import com.cmcc.know.service.KnowTypeService;

/**
 * 
 * ClassName: KnowledgeServiceImpl 
 * @Description: TODO 资料库业务实现类
 * @author zengzhibin
 * @date 2019年2月27日
 */
@Service
public class KnowTypeServiceImpl implements KnowTypeService {

	private Logger log =  LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private KnowTypeDao knowTypeDao;
	@Autowired
	private UserService userService;
	
	@Override
	public Integer add(KnowType knowType) {
		knowType.setTypeId(IdGenerateUtil.uuid3());
		knowType.setCreateUser(userService.getUserId());
		knowType.setCreateTime(new Date());
		return knowTypeDao.insert(knowType);
	}

	@Override
	public Integer update(KnowType knowType) {
		knowType.setCreateUser(userService.getUserId());
		knowType.setCreateTime(new Date());
		return knowTypeDao.updateByPrimaryKey(knowType);
	}

	@Override
	public Integer delete(String typeId) {
		return knowTypeDao.deleteByPrimaryKey(typeId);
	}

	@Override
	public List<KnowType> getAll() {
		return knowTypeDao.selectAll();
	}

}
