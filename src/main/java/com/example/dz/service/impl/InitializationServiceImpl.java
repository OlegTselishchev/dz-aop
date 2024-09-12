package com.example.dz.service.impl;

import com.example.dz.annotation.TrackAsyncTime;
import com.example.dz.annotation.TrackTime;
import com.example.dz.service.InitializationService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class InitializationServiceImpl implements InitializationService {

    @TrackTime
    @Override
    public void testMethodSync() {
        log.info("testMethod");
        try {
            int timeout = ThreadLocalRandom.current().nextInt(3, 9);
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            log.error("[ERROR] {}", e.getMessage());
        }
    }


    @TrackAsyncTime
    @Async
    @Override
    public void testMethodAsync() {
        log.info("testMethodAsync");
        try {
            int timeout = ThreadLocalRandom.current().nextInt(2, 9);
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            log.error("[ERROR] {}", e.getMessage());
        }
    }

    @Override
    public void errorMethod() {
        log.info("errorMethod - run: ");
        throw new RuntimeException("Error message");
    }
}
