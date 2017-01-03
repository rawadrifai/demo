package com.demo.util;

import com.demo.request.SignupRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${aspect-package}")
    public final String aspectPackage = "com.demo.*.*";

    @Before("within(" + aspectPackage + ")")
    public void before(JoinPoint joinPoint) throws Throwable {

        StringBuffer stringBuffer = new StringBuffer()
                .append("hijacked method : " + joinPoint.getSignature())
                .append("\nhijacked arguments : " + Arrays.toString(joinPoint.getArgs()))
                .append("\nProceeding with " + joinPoint.getSignature());

        LOG.info(stringBuffer.toString());

    }

    @After("within(" + aspectPackage + ")")
    public void after(JoinPoint joinPoint)
    {
        LOG.info("Done with " + joinPoint.getSignature());
    }

    @AfterReturning(pointcut = "within(" + aspectPackage + ")", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result)
    {
        LOG.info("Return from " + joinPoint.getSignature().getName() + ": " + result.toString());
    }
}
