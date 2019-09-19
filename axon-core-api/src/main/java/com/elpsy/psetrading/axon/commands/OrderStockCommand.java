package com.elpsy.psetrading.axon.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@AllArgsConstructor
@Getter
public class OrderStockCommand {
    @TargetAggregateIdentifier
    private final String transactionId;
    private final String orderType;
    private final String stockCode;
    private final double orderPrice;
    private final int shares;

}