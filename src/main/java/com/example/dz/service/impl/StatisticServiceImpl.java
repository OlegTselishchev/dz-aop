package com.example.dz.service.impl;

import com.example.dz.model.AvgStatisticResponse;
import com.example.dz.model.MaxStatisticResponse;
import com.example.dz.model.MinStatisticResponse;
import com.example.dz.model.SumStatisticResponse;
import com.example.dz.database.repository.TrackTimeStatisticRepository;
import com.example.dz.service.StatisticService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StatisticServiceImpl implements StatisticService {

    private final TrackTimeStatisticRepository trackTimeRepository;

    @Override
    public List<MaxStatisticResponse> findMaxTrackTime() {
        return trackTimeRepository.findMaxTrackTimeForAllMethods();
    }

    @Override
    public List<MinStatisticResponse> findMinTrackTime() {
        return trackTimeRepository.findMinTrackTimeForAllMethods();
    }

    @Override
    public List<SumStatisticResponse> findSumTrackTime() {
        return trackTimeRepository.findSumTrackTimeForAllMethods();
    }

    @Override
    public List<AvgStatisticResponse> findAvgTrackTime() {
        return trackTimeRepository.findAvgTrackTimeForAllMethods();
    }
}
