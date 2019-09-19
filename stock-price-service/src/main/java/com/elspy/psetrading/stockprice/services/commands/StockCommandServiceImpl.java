package com.elspy.psetrading.stockprice.services.commands;


import com.elpsy.psetrading.axon.commands.CreateStockCommand;
import com.elpsy.psetrading.axon.commands.PriceStockCommand;
import com.elspy.psetrading.stockprice.dto.commands.CreateStockDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
@AllArgsConstructor
public class StockCommandServiceImpl implements StockCommandService {

    private CommandGateway commandGateway;

    @Override
    public CompletableFuture<String> createStock(CreateStockDTO createStockDTO) {
        return commandGateway.send(new CreateStockCommand(createStockDTO.getStockCode(), createStockDTO.getStockName(), createStockDTO.getSector(), createStockDTO.getPrice()));
    }

    @Override
    public CompletableFuture<String> tickedPrice(String stockCode, Double currPrice) {
        Double change = generateRandomChange();
        Double updatePrice = getUpdatedPrice(change,currPrice);
        return commandGateway.send(new PriceStockCommand(stockCode, updatePrice, change));
    }


    private Double generateRandomChange(){
        double min = -3.00;
        double max = 3.00;
        double range = max - min + 1.00;
        double change = (Math.random() * range ) + min;
        BigDecimal bd = BigDecimal.valueOf(change);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }


    private Double getUpdatedPrice(Double change, Double price){
        double up = price + ((change / 100) * price);
        BigDecimal bd = BigDecimal.valueOf(up);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
