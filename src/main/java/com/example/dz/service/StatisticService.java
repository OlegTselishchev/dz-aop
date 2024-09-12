package com.example.dz.service;

import com.example.dz.model.AvgStatisticResponse;
import com.example.dz.model.MaxStatisticResponse;
import com.example.dz.model.MinStatisticResponse;
import com.example.dz.model.SumStatisticResponse;

import java.util.List;


public interface StatisticService {
    List<MaxStatisticResponse> findMaxTrackTime();
    List<MinStatisticResponse> findMinTrackTime();
    List<SumStatisticResponse> findSumTrackTime();
    List<AvgStatisticResponse> findAvgTrackTime();
}
