package com.elspy.psetrading.stockprice.dto.commands;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StockPriceTickDTO {
    private String stockCode;
    private Double price;
}
