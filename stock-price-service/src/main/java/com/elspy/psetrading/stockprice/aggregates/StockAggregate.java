package com.elspy.psetrading.stockprice.aggregates;

import com.elpsy.psetrading.axon.commands.CreateStockCommand;
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

    @EventSourcingHandler
    protected void on(StockCreatedEvent stockCreatedEvent){
        this.stockCode = stockCreatedEvent.getStockCode();
    }

}
