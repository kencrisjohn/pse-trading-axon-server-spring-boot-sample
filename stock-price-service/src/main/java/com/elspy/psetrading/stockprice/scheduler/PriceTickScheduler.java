package com.elspy.psetrading.stockprice.scheduler;

import com.elspy.psetrading.stockprice.dao.repo.StockRepo;
import com.elspy.psetrading.stockprice.services.commands.StockCommandService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
@EnableScheduling
public class PriceTickScheduler {

    private StockRepo stockRepo;
    private StockCommandService stockCommandService;

    //Run every 3mins
    @Scheduled(cron = "3 * * * * *")
    public void scheduledPriceChange(){
        log.info("change all stock price for demo");
        stockRepo.findAll().forEach(s->{
            stockCommandService.tickedPrice(s.getStockCode(), s.getPrice());
        });
    }

}
