package com.example.dz.listener;

import com.example.dz.service.InitializationService;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class InitListener {

    private final InitializationService initializationService;

    @EventListener(ApplicationReadyEvent.class)
    public void runJobsInit() {
//        initializationService.testMethodSync();
//        initializationService.testMethodSync();
//        initializationService.testMethodSync();
//        initializationService.testMethodAsync();
//        initializationService.testMethodAsync();
//        initializationService.testMethodAsync();
        //initializationService.errorMethod();
    }
}
