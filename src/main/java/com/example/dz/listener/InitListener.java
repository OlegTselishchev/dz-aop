package com.example.dz.listener;

import com.example.dz.service.TestService;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class InitListener {

    private final TestService testService;

    @EventListener(ApplicationReadyEvent.class)
    public void runJobsInit() {
        testService.testMethodSync();
        testService.testMethodSync();
        testService.testMethodSync();
        testService.testMethodAsync();
        testService.testMethodAsync();
        testService.testMethodAsync();
    }
}
