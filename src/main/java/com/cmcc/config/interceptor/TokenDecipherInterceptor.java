package com.cmcc.config.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.cmcc.common.bean.BaseUser;
import com.cmcc.common.service.RedisService;

public class TokenDecipherInterceptor extends HandlerInterceptorAdapter {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	private static final String JWT_TOKEN_HEADER = "Authorization";
	private static final String JWT_TOKEN_PREFIX = "Bearer";
	
	private RedisService redisService;
	
	
	public TokenDecipherInterceptor(RedisService redisService) {
		this.redisService = redisService;
	}


	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String authInfo = request.getHeader(JWT_TOKEN_HEADER);
		String token = StringUtils.removeStart(authInfo, JWT_TOKEN_PREFIX+" ");
		if(token!=null){
			try {
				DecodedJWT jwt = JWT.decode(token);
				String userCode=jwt.getSubject();
				//获取用户权限 
		        if(userCode!=null){
					Map<String,Object> map = redisService.getMap("USER"+userCode);
					//获取token中的自定义数据 
					BaseUser baseUser = new BaseUser();
			       	baseUser.setUserId(map.get("userId")!=null?map.get("userId").toString():"");
			       	baseUser.setUserName(map.get("userName")!=null?map.get("userName").toString():"");
			       	baseUser.setUserAccount(map.get("userAccount")!=null?map.get("userAccount").toString():"");
			       	baseUser.setOrgId(map.get("orgId")!=null?map.get("orgId").toString():"");
			       	baseUser.setCompanyId(map.get("companyId")!=null?map.get("companyId").toString():"");
			       	baseUser.setTenantId(map.get("tenantId")!=null?map.get("tenantId").toString():"");
			       	baseUser.setUserTel(map.get("userTel")!=null?map.get("userTel").toString():"");
			        request.setAttribute("currentUser", baseUser);
		        }
			} catch (Exception e) {
				log.error("token解析异常：",e);
			}
		}
        return true;
    }
}
