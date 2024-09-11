package com.example.dz.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrackTimeMinStatistic {
    private Boolean isAsync;
    private String methodName;
    private Integer minTimeWork;
}
