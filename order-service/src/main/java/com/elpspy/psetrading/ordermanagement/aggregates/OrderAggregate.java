package com.elpspy.psetrading.ordermanagement.aggregates;

import com.elpsy.psetrading.axon.commands.OrderStockCommand;
import com.elpsy.psetrading.axon.events.OrderStockEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class OrderAggregate {
    @AggregateIdentifier
    private String transactionId;

    public OrderAggregate() {
    }

    @CommandHandler
    public OrderAggregate(OrderStockCommand cmd){
        OrderStockEvent orderStockEvent = new OrderStockEvent(cmd.getStockCode(), cmd.getStockCode(), cmd.getOrderType(), cmd
                .getOrderPrice(), cmd.getShares());
        AggregateLifecycle.apply(orderStockEvent);
    }

    @EventSourcingHandler
    protected void on(OrderStockEvent orderStockEvent){
        this.transactionId = orderStockEvent.getTransactionId();
    }
}
