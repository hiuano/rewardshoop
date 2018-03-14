package com.rewardshoop.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomizeExceptionResolver implements HandlerExceptionResolver{

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        String msg="";
        if(ex instanceof CustomizeException){
            msg = ((CustomizeException) ex).getMessage();
        }else{
            msg = "未知错误";
        }

        ModelAndView mv = new ModelAndView();
        mv.addObject("msg",msg);
        mv.setViewName("error/error");
        return mv;
    }
}
