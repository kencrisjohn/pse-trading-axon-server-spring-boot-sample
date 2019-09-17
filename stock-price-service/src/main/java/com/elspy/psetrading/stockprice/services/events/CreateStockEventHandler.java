package com.elspy.psetrading.stockprice.services.events;


import com.elpsy.psetrading.axon.events.StockCreatedEvent;
import com.elspy.psetrading.stockprice.dao.domain.Stock;
import com.elspy.psetrading.stockprice.dao.repo.StockRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class CreateStockEventHandler {

    private StockRepo stockRepo;
    private QueryUpdateEmitter queryUpdateEmitter;

    @EventHandler
    public void on(StockCreatedEvent evt){
        log.info("process creation of new stock..");
        Optional<Stock> stockOpt = stockRepo.findById(evt.getStockCode());
        if(!stockOpt.isPresent()) {
            Stock stock = new Stock(evt.getStockCode(), evt.getStockName(), evt.getPrice(), evt.getSector());
            stockRepo.save(stock);
        }
    }
}
