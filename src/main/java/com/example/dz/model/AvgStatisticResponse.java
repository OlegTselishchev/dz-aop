package com.example.dz.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AvgStatisticResponse {
    private Boolean isAsync;
    private String methodName;
    private Double avgTimeWork;
}
