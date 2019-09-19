package com.elpsy.psetrading.axon.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class PriceStockEvent {
    private String stockCode;
    private double price;
    private double change;

}
