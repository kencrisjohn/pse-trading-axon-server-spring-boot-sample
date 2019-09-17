package com.elspy.psetrading.stockprice.services.commands;

import com.elspy.psetrading.stockprice.dto.commands.CreateStockDTO;

import java.util.concurrent.CompletableFuture;

public interface StockCommandService {
    public CompletableFuture<String> createStock(CreateStockDTO createStockDTO);

}
