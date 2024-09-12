package com.example.dz.aspect;

import com.example.dz.service.TrackTimeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
@Aspect
@Slf4j
public class TrackTimeAspect {

    private final TrackTimeService trackTimeServiceSync;

    @Pointcut("@annotation(com.example.dz.annotation.TrackTime)")
    public void trackTimePointcut() { }

    @Around("trackTimePointcut()")
    public void trackTime(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            long start = System.currentTimeMillis();
            joinPoint.proceed();
            trackTimeServiceSync.trackTime(start, joinPoint.getSignature().toLongString());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}
