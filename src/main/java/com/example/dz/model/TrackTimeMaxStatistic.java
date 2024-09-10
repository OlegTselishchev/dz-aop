package com.example.dz.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrackTimeMaxStatistic {
    private Boolean isAsync;
    private String methodPath;
    private String methodName;
    private Integer maxTimeWork;
}
