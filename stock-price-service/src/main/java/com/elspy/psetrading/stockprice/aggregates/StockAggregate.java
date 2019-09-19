package com.elspy.psetrading.stockprice.aggregates;

import com.elpsy.psetrading.axon.commands.CreateStockCommand;
import com.elpsy.psetrading.axon.commands.PriceStockCommand;
import com.elpsy.psetrading.axon.events.PriceStockEvent;
import com.elpsy.psetrading.axon.events.StockCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class StockAggregate {

    @AggregateIdentifier
    private String stockCode;

    public StockAggregate() {
    }

    @CommandHandler
    public StockAggregate(CreateStockCommand cmd){
        AggregateLifecycle.apply(new StockCreatedEvent(cmd.getStockCode(),cmd.getStockName(),cmd.getSector(),cmd.getPrice()));
    }

    @CommandHandler
    public void on(PriceStockCommand cmd){
        AggregateLifecycle.apply(new PriceStockEvent(cmd.getStockCode(),cmd.getPrice(), cmd.getChange()));
    }


    @EventSourcingHandler
    protected void on(StockCreatedEvent stockCreatedEvent){
        this.stockCode = stockCreatedEvent.getStockCode();
    }

    @EventSourcingHandler
    protected void on(PriceStockEvent priceStockEvent){
        this.stockCode = priceStockEvent.getStockCode();
    }

}
