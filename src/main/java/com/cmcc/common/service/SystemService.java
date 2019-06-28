package com.cmcc.common.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cmcc.common.bean.BaseUser;
import com.cmcc.common.bean.Result;
import com.cmcc.common.bean.SysUser;
import com.cmcc.common.service.impl.SystemServiceImpl;


/**
 * 
 * ClassName: SystemService 
 * @Description RPC调用用户相关服务
 * @author zengzhibin
 * @date 2019年4月3日
 */
@FeignClient(name="user-server",fallback=SystemServiceImpl.class)
public interface SystemService {
	
    
   
    @RequestMapping(value = "/feign/getZhgjUsers", method= RequestMethod.POST)
    List<SysUser> getZhgjUsers(@RequestBody BaseUser baseUser);
    
    
    /**
     * 根据ID删除用户
     * @param userId
     * @return
     */
    @RequestMapping(value = "/feign/user/{userId}", method= RequestMethod.DELETE)
	public Integer removeUser(@PathVariable(value="userId") String userId);
    
    /**
     * 添加用户
     * @param user
     * @return
     */
    @RequestMapping(value = "/feign/register", method= RequestMethod.PUT)
	public Result register(@RequestBody SysUser user);
}
