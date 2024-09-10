package com.example.dz.service;


import com.example.dz.model.TrackTimeMaxStatistic;
import com.example.dz.model.TrackTimeMinStatistic;
import com.example.dz.model.TrackTimeModel;
import com.example.dz.model.TrackTimeAvgStatistic;
import com.example.dz.model.TrackTimeSumStatistic;
import com.example.dz.repository.TrackTimeStatisticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TrackTimeStatisticService {

    private final TrackTimeStatisticRepository trackTimeRepository;

    @Autowired
    public TrackTimeStatisticService(TrackTimeStatisticRepository trackTimeRepository) {
        this.trackTimeRepository = trackTimeRepository;
    }

    @Transactional
    public void save(TrackTimeModel trackTime) {
        trackTimeRepository.save(trackTime);
    }

    public List<TrackTimeMaxStatistic> findMaxTrackTime() {
        return trackTimeRepository.findMaxTrackTimeForAllMethods();
    }

    public List<TrackTimeMinStatistic> findMinTrackTime() {
        return trackTimeRepository.findMinTrackTimeForAllMethods();
    }

    public List<TrackTimeSumStatistic> findSumTrackTime() {
        return trackTimeRepository.findSumTrackTimeForAllMethods();
    }

    public List<TrackTimeAvgStatistic> findAvgTrackTime() {
        return trackTimeRepository.findAvgTrackTimeForAllMethods();
    }
}
