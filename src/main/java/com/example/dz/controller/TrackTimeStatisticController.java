package com.example.dz.controller;

import com.example.dz.model.TrackTimeAvgStatistic;
import com.example.dz.model.TrackTimeMaxStatistic;
import com.example.dz.model.TrackTimeMinStatistic;
import com.example.dz.model.TrackTimeSumStatistic;
import com.example.dz.service.TrackTimeStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/rest/statistic")
public class TrackTimeStatisticController {

    private final TrackTimeStatisticService trackTimeService;

    @Autowired
    public TrackTimeStatisticController(TrackTimeStatisticService trackTimeService) {
        this.trackTimeService = trackTimeService;
    }

    @GetMapping("/min")
    public List<TrackTimeMinStatistic> getMinTime() {
        return trackTimeService.findMinTrackTime();
    }

    @GetMapping("/max")
    public List<TrackTimeMaxStatistic> getMaxTime() {
        return trackTimeService.findMaxTrackTime();
    }

    @GetMapping("/sum")
    public List<TrackTimeSumStatistic> getSumTime() {
        return trackTimeService.findSumTrackTime();
    }

    @GetMapping("/avg")
    public List<TrackTimeAvgStatistic> getAvgTime() {
        return trackTimeService.findAvgTrackTime();
    }
}
