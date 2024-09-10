package com.example.dz.aspect;

import com.example.dz.model.TrackTimeModel;
import com.example.dz.service.TrackTimeStatisticService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@Aspect
@Slf4j
public class TrackTimeAspect {

    private final TrackTimeStatisticService trackTimeService;

    @Autowired
    public TrackTimeAspect(TrackTimeStatisticService trackTimeService) {
        this.trackTimeService = trackTimeService;
    }

    @Pointcut("@annotation(com.example.dz.annotation.TrackTime)")
    public void trackTimePointcut() { }

    @Around("trackTimePointcut()")
    public void trackTime(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            long start = System.currentTimeMillis();
            joinPoint.proceed();
            long result = System.currentTimeMillis() - start;

            log.info("INTO DB mName: " + joinPoint.getSignature().getName() + " TIME: " + result);

            TrackTimeModel trackTimeModel = new TrackTimeModel();
            trackTimeModel.setIsAsync(false);
            trackTimeModel.setMethodPath(joinPoint.getSignature().getDeclaringTypeName());
            trackTimeModel.setMethodName(joinPoint.getSignature().getName());
            trackTimeModel.setTimeWork((int)result);
            trackTimeService.save(trackTimeModel);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

    }

}
