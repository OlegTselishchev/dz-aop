package com.example.dz.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SumStatisticResponse {
    private Boolean isAsync;
    private String methodName;
    private Long sumTimeWork;
}
