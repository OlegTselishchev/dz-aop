package com.example.dz.aspect;

import com.example.dz.model.TrackTimeModel;
import com.example.dz.service.TrackTimeStatisticService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
@Aspect
@Slf4j
public class TrackAsyncTimeAspect {

    private final TrackTimeStatisticService trackTimeService;

    public TrackAsyncTimeAspect(TrackTimeStatisticService trackTimeService) {
        this.trackTimeService = trackTimeService;
    }

    @Pointcut("@annotation(com.example.dz.annotation.TrackAsyncTime)")
    public void trackAsyncTimePointcut() {}

    @Around("trackAsyncTimePointcut()")
    public void trackTime(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            long start = System.currentTimeMillis();
            joinPoint.proceed();
            long result = System.currentTimeMillis() - start;

            CompletableFuture.runAsync(() -> {
                log.info("INTO DB mName: " + joinPoint.getSignature().getName() + " TIME: " + result);

                TrackTimeModel trackTimeModel = new TrackTimeModel();
                trackTimeModel.setIsAsync(true);
                trackTimeModel.setMethodName(joinPoint.getSignature().toLongString());
                trackTimeModel.setTimeWork((int) result);
                trackTimeService.save(trackTimeModel);
            });
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

}
