package com.example.dz.service.impl;

import com.example.dz.database.entity.TrackTimeStatistic;
import com.example.dz.database.repository.TrackTimeStatisticRepository;
import com.example.dz.service.TrackTimeService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class  AbstractTrackTimeService implements TrackTimeService {

    private final TrackTimeStatisticRepository trackTimeRepository;

    public AbstractTrackTimeService(TrackTimeStatisticRepository trackTimeRepository) {
        this.trackTimeRepository = trackTimeRepository;
    }

    protected void logAndSaveResultDuration(long durationResult, String methodName, boolean isAsync) {
        log.info("INTO DB mName: " + methodName + " TIME: " + durationResult);

        TrackTimeStatistic trackTimeModel = new TrackTimeStatistic();
        trackTimeModel.setIsAsync(isAsync);
        trackTimeModel.setMethodName(methodName);
        trackTimeModel.setTimeWork((int) durationResult);
        trackTimeRepository.save(trackTimeModel);
    }
}
