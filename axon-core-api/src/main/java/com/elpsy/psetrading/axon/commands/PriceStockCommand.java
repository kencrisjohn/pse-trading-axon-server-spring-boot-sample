package com.elpsy.psetrading.axon.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@AllArgsConstructor
@Getter
public class PriceStockCommand {
    @TargetAggregateIdentifier
    private final String stockCode;
    private final double price;
    private final double change;
}