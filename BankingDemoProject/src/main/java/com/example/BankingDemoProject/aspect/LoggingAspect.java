package com.example.BankingDemoProject.aspect;

import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
@Slf4j
public class LoggingAspect {


    @Around("execution(* com.example.BankingDemoProject.controller.*.*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("Request - {}: {}", joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
        Object result = joinPoint.proceed();
        JSONObject jsonObject = new JSONObject(result);
        log.info("Response - {}", jsonObject);
        return result;
}

}
