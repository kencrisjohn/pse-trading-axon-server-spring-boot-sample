package com.elspy.psetrading.stockprice.services.commands;


import com.elpsy.psetrading.axon.commands.CreateStockCommand;
import com.elspy.psetrading.stockprice.dto.commands.CreateStockDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
@AllArgsConstructor
public class StockCommandServiceImpl implements StockCommandService {

    private CommandGateway commandGateway;


    @Override
    public CompletableFuture<String> createStock(CreateStockDTO createStockDTO) {
            return commandGateway.send(new CreateStockCommand(createStockDTO.getStockCode(),createStockDTO.getStockName(),createStockDTO.getSector(),createStockDTO.getPrice()));
    }
}
