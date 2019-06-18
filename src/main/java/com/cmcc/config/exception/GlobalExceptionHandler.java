package com.cmcc.config.exception;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.cmcc.common.bean.Result;
import com.cmcc.common.bean.ResultCode;

@ControllerAdvice
public class GlobalExceptionHandler {

	private Logger log =  LoggerFactory.getLogger(this.getClass());

	/**
     * 系统异常处理，比如：404,500
     * @param req
     * @param resp
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result defaultErrorHandler(HttpServletRequest req, Exception e){
    	log.error("",e);
        if (e instanceof NoHandlerFoundException) {
             return Result.failure(ResultCode.INTERFACE_ADDRESS_INVALID);
        }else{
        	return Result.failure(ResultCode.SYSTEM_INNER_ERROR);
        }
    }

}