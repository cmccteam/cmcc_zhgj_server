package com.cmcc.common.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cmcc.common.bean.BaseUser;
import com.cmcc.common.bean.SysUser;
import com.cmcc.common.service.SystemService;


@Component
public class SystemServiceImpl implements SystemService{

	@Override
	public List<SysUser> getZhgjUsers(BaseUser baseUser) {
		return null;
	}


}
