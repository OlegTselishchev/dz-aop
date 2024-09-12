package com.example.dz.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MaxStatisticResponse {
    private Boolean isAsync;
    private String methodName;
    private Integer maxTimeWork;
}
