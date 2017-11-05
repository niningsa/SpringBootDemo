package com.ln.girl.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 *  横切，AOP拦截所有请求(把通用功能抽取出来)
 */
@Aspect
@Component
public class HttpAspect {

    private static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    // 词表达式表示：拦截GirlController 下的所有方法的参数
    @Pointcut("execution(public * com.ln.girl.controller.GirlController.*(..))")
    public void log() {
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        logger.info("url={}", request.getRequestURL());
        logger.info("method={}", request.getMethod());
        logger.info("ip={}", request.getRemoteAddr());
        logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName()+" - "+joinPoint.getSignature().getName());
        logger.info("args={}", joinPoint.getArgs());


    }

    @After("log()")
    public void doAfter() {
        logger.info("22222S");
    }

    // 返回的数据的时候拦截响应的内容
    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object) {
        logger.info("response={}", object);
    }

}

