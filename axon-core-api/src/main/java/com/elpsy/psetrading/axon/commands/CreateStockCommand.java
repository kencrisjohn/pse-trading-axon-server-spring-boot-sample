package com.elpsy.psetrading.axon.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
@AllArgsConstructor
@Getter
public class CreateStockCommand {
    @TargetAggregateIdentifier
    private final String stockCode;
    private final String stockName;
    private final String sector;
    private final double price;


}