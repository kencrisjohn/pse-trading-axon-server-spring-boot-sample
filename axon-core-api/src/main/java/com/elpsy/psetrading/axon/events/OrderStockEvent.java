package com.elpsy.psetrading.axon.events;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class OrderStockEvent {

    private final String transactionId;
    private final String stockCode;
    private final String orderType;
    private final double orderPrice;
    private final int shares;

}
