package com.elspy.psetrading.stockprice.vo;

import lombok.Builder;

@Builder
public class ApiResponse {
    private Integer status;
    private String message;
}
