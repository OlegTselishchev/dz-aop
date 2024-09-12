package com.example.dz.service.impl;


import com.example.dz.database.repository.TrackTimeStatisticRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
public class TrackTimeServiceSync extends AbstractTrackTimeService {

    public TrackTimeServiceSync(TrackTimeStatisticRepository trackTimeRepository) {
        super(trackTimeRepository);
    }

    @Override
    public void trackTime(long startTimestamp, String methodName) {
        long result = System.currentTimeMillis() - startTimestamp;
        logAndSaveResultDuration(result, methodName, false);
    }
}
