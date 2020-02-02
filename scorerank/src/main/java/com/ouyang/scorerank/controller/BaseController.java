package com.ouyang.scorerank.controller;

import com.ouyang.scorerank.error.BusinessException;
import com.ouyang.scorerank.error.EmbusinessError;
import com.ouyang.scorerank.response.CommonReturnType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName BaseController
 * @Description TODO
 * @Author ouyang
 * @Data 2020-01-30 15:16
 * @Version 1.0
 **/

public class BaseController {

    // Common error handler
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Object handlerException(HttpServletRequest request, Exception ex){
        Map<String, Object> responseData = new HashMap<>();

        if(ex instanceof BusinessException){
            BusinessException businessException = (BusinessException)ex;
            responseData.put("errCode", businessException.getErrCode());
            responseData.put("errMsg", businessException.getErrMsg());
        }else{
            responseData.put("errCode", EmbusinessError.UNKNOWN_ERROR.getErrCode());
            responseData.put("errMsg", EmbusinessError.UNKNOWN_ERROR.getErrMsg());

        }
        return CommonReturnType.create(responseData, "fail");
    }

}
