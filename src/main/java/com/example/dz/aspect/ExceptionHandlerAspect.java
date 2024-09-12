package com.example.dz.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class ExceptionHandlerAspect {

    @AfterThrowing(pointcut = "execution(* com.example.dz.service.*.*())", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Exception e) {
        log.info("Error for method: {}", joinPoint.getSignature().toLongString());
        log.info("ERROR: {}", e.getMessage());
    }
}
