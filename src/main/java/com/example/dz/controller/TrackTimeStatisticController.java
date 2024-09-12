package com.example.dz.controller;

import com.example.dz.model.AvgStatisticResponse;
import com.example.dz.model.MaxStatisticResponse;
import com.example.dz.model.MinStatisticResponse;
import com.example.dz.model.SumStatisticResponse;
import com.example.dz.service.StatisticService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1/rest/statistic")
public class TrackTimeStatisticController {

    private final StatisticService statisticService;

    @Operation(description = "Get min work time.")
    @GetMapping("/min")
    public List<MinStatisticResponse> getMinTime() {
        return statisticService.findMinTrackTime();
    }

    @Operation(description = "Get max work time..")
    @GetMapping("/max")
    public List<MaxStatisticResponse> getMaxTime() {
        return statisticService.findMaxTrackTime();
    }

    @Operation(description = "Get sum work time..")
    @GetMapping("/sum")
    public List<SumStatisticResponse> getSumTime() {
        return statisticService.findSumTrackTime();
    }

    @Operation(description = "Get avg work time..")
    @GetMapping("/avg")
    public List<AvgStatisticResponse> getAvgTime() {
        return statisticService.findAvgTrackTime();
    }
}
