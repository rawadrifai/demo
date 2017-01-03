package com.demo.util;

import com.demo.request.SignupRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by rawad.elrifai on 12/29/16.
 */
@Aspect
@Component
public class MyAspect {

    private static final Logger LOG = LoggerFactory.getLogger(MyAspect.class);


    //@Before("within(com.demo.*.*)")
    public void before(JoinPoint joinPoint)
    {
        System.out.println(joinPoint.getKind() + "-" + joinPoint.getTarget().getClass().getName());
        LOG.info("AOP Activated BEFORE " + joinPoint.getSignature().getName() + " with params: " + Arrays.toString(joinPoint.getArgs()));
    }

    //@After("within(com.demo.*.*)")
    public void after(JoinPoint joinPoint)
    {
        LOG.info("AOP Activated AFTER " + joinPoint.getSignature().getName());
    }

    //@AfterReturning(pointcut = "within(com.demo.*.*)", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result)
    {
        LOG.info("AOP Activated AFTER RETURNING " + joinPoint.getSignature().getName());
        LOG.info(result.toString());
    }
}
