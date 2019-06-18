package com.cmcc.config.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.cmcc.common.service.RedisService;
import com.cmcc.config.interceptor.CurrentUserMethodArgumentResolver;
import com.cmcc.config.interceptor.TokenDecipherInterceptor;

@Configuration
public class MyWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {
	
	@Autowired
	RedisService redisService;
	
    @Bean
    public TokenDecipherInterceptor tokenDecipherInterceptor() {
        return new TokenDecipherInterceptor(redisService);
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册拦截器
        InterceptorRegistration ir = registry.addInterceptor(tokenDecipherInterceptor());
        // 配置拦截的路径
        ir.addPathPatterns("/**");
        // 配置不拦截的路径
        ir.excludePathPatterns("**/swagger-ui.html");
    }
    
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(currentUserMethodArgumentResolver());
        super.addArgumentResolvers(argumentResolvers);
    }
    @Bean
    public CurrentUserMethodArgumentResolver currentUserMethodArgumentResolver() {
        return new CurrentUserMethodArgumentResolver();
    }
}