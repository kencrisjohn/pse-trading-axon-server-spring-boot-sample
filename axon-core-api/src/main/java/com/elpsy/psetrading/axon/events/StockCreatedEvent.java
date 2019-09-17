package com.elpsy.psetrading.axon.events;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class StockCreatedEvent {

    private final String stockCode;
    private final String stockName;
    private final String sector;
    private final double price;

}
