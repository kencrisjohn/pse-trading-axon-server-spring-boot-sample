package com.elspy.psetrading.stockprice.controller;


import com.elspy.psetrading.stockprice.dto.commands.CreateStockDTO;
import com.elspy.psetrading.stockprice.services.commands.StockCommandService;
import com.elspy.psetrading.stockprice.vo.ApiResponse;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;


@RestController(value = "/stock/")
@AllArgsConstructor
public class StockController {

    private StockCommandService stockCommandService;
    private EventStore eventStore;

    @PostMapping("new")
    public CompletableFuture<String> createStock(@RequestBody CreateStockDTO createStockDTO){
        Stream stream = eventStore.readEvents(createStockDTO.getStockCode()).asStream();
        if(stream.findAny().isPresent()) {
            return CompletableFuture.supplyAsync(()-> new Gson().toJson(ApiResponse.builder().message("Stock already created").status(201).build()));
        }
        return stockCommandService.createStock(createStockDTO);
    }

}
