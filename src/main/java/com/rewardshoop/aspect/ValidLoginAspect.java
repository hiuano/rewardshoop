package com.rewardshoop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Aspect
@Component
public class ValidLoginAspect {

    @Pointcut("execution(* com.rewardshoop.adminController..*.*(..)) && !execution(* com.rewardshoop.adminController..login(..))")
    public void valid() {
    }

    //环绕通知,环绕增强，相当于MethodInterceptor
    @Around("valid()")
    public Object arround(ProceedingJoinPoint pjp) {
        try {
            //取参数
            Object[] objects = pjp.getArgs();

            //如果没有参数,直接返回方法主体
            if (objects.length == 0) {
                return pjp.proceed();
            } else {
                //有参数,循环,取HttpServletRequest
                for (Object obj : objects) {
                    //这步取HttpServletRequest这个类型的参数,验证session是否有userId登陆验证,没有的话返回登录界面
                    if (obj instanceof HttpServletRequest) {
                        HttpServletRequest request = (HttpServletRequest) obj;
                        HttpSession session = request.getSession();
                        if (session.getAttribute("id") == null) {
                            ModelAndView mv = new ModelAndView();
                            mv.setViewName("index");
                            return mv;
                        } else {
                            return pjp.proceed();
                        }
                    }
                    //这个是取HttpServletResponse,暂时没啥用,留着
                    //                    else if (obj instanceof HttpServletResponse) {
                    //
                    //                    }

                }
                //这步是,如果参数没有这步取HttpServletRequest这个类型,则直接执行方法主体
                return pjp.proceed();
            }
        } catch (Throwable e) {
            ModelAndView mv = new ModelAndView();
            mv.addObject("errMsg", e.getMessage());
            mv.setViewName("error/error");
            return mv;
        }


    }
}
