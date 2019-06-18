package com.cmcc.config.interceptor;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

import com.cmcc.common.bean.BaseUser;

public class CurrentUserMethodArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().isAssignableFrom(BaseUser.class)
                && parameter.hasParameterAnnotation(CurrentUser.class);
    }
    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        BaseUser userInfo = (BaseUser) webRequest.getAttribute("currentUser", RequestAttributes.SCOPE_REQUEST);
        if (userInfo != null) {
            return userInfo;
        }else{
        	return new BaseUser();
        }
        //throw new MissingServletRequestPartException("currentUser");
    }
}
