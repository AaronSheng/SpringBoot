package com.aaron.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by Aaron Sheng on 9/15/16.
 */
@Aspect
@Component
public class LoggerAspect {
    private Logger logger = LogManager.getLogger(LoggerAspect.class);

    /*
    @Before("execution(* com.aaron.web.*.*(..))")
    public void beforeGetName(JoinPoint joinPoint) {
        logger.info("before注入");
        logger.info(joinPoint.getTarget().getClass());
        logger.info(joinPoint.getSignature().getName());
    }

    @After("execution(* com.aaron.web.*.*(..))")
    public void afterGetName(JoinPoint joinPoint) {
        logger.info("after注入");
        logger.info(joinPoint.getTarget().getClass());
        logger.info(joinPoint.getSignature().getName());
    }


    @Around("execution(* com.aaron.web.*.*(..))")
    public Object arrounGetName(ProceedingJoinPoint pjp) throws Throwable {
        logger.info(pjp.getTarget().getClass());
        logger.info(pjp.getSignature().getName());
        long before = System.currentTimeMillis();
        Object object = pjp.proceed();
        long after = System.currentTimeMillis();
        logger.info("cost: " + (after - before) + "ms");
        return object;
    }
    */
}
