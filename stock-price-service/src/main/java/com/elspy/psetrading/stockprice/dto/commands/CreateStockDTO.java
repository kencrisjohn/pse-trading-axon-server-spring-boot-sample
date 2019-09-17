package com.elspy.psetrading.stockprice.dto.commands;

import lombok.Data;

@Data
public class CreateStockDTO {
    private String stockCode;
    private String stockName;
    private String sector;
    private Double price;
}
