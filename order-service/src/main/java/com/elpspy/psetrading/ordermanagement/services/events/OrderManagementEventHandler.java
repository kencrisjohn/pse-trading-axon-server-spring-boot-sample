package com.elpspy.psetrading.ordermanagement.services.events;


import com.elpsy.psetrading.axon.events.OrderStockEvent;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class OrderManagementEventHandler {

    @EventHandler
    public void on(OrderStockEvent orderStockEvent){

    }

}
