package com.example.dz.service;

import com.example.dz.annotation.TrackAsyncTime;
import com.example.dz.annotation.TrackTime;
import lombok.extern.slf4j.Slf4j;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class TestService {

    @TrackTime
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
    public void testMethodAsync() {
        log.info("testMethodAsync");
        try {
            int timeout = ThreadLocalRandom.current().nextInt(2, 9);
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            log.error("[ERROR] {}", e.getMessage());
        }
    }
}
