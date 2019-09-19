package com.elspy.psetrading.stockprice.services.events;


import com.elpsy.psetrading.axon.events.PriceStockEvent;
import com.elspy.psetrading.stockprice.dao.domain.Stock;
import com.elspy.psetrading.stockprice.dao.domain.StockPriceLedger;
import com.elspy.psetrading.stockprice.dao.repo.StockPriceLedgerRepo;
import com.elspy.psetrading.stockprice.dao.repo.StockRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class PriceStockEventHandler {

    private StockRepo stockRepo;
    private StockPriceLedgerRepo stockPriceLedgerRepo;
    private static DecimalFormat df = new DecimalFormat("#.##");


    @EventHandler
//    @DisallowReplay
    public void on(PriceStockEvent evt){
        log.info("process event..{}", evt);
        Optional<Stock> stockOpt = stockRepo.findById(evt.getStockCode());
        if(stockOpt.isPresent()) {
            Stock stock = stockOpt.get();
            final Optional<StockPriceLedger> lastLedger = stockPriceLedgerRepo.findTopByOrderByCreateTimeDesc();
            if(lastLedger.isPresent()){
                final StockPriceLedger priceLedger = lastLedger.get();
                Double oldPrice = priceLedger.getCurrPrice();
                priceLedger.setCurrPrice(evt.getPrice());
                priceLedger.setOldPrice(oldPrice);
                priceLedger.setPercentageChange(evt.getChange());
                stockPriceLedgerRepo.save(priceLedger);
                stock.setPrice(evt.getPrice());
                stockRepo.save(stock);
            }else{
                StockPriceLedger stockPriceLedger = new StockPriceLedger();
                stockPriceLedger.setStockCode(stock.getStockCode());
                stockPriceLedger.setCurrPrice(stock.getPrice());
                stockPriceLedger.setOldPrice(stock.getPrice());
                stockPriceLedger.setPercentageChange(evt.getChange());
                stockPriceLedgerRepo.save(stockPriceLedger);
                stock.setPrice(evt.getPrice());
                stockRepo.save(stock);
            }
        }
    }


}
