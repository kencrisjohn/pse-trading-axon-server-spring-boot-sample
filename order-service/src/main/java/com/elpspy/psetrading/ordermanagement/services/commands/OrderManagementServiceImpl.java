package com.elpspy.psetrading.ordermanagement.services.commands;


import io.netty.util.concurrent.CompleteFuture;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class OrderManagementServiceImpl implements OrderManagementService {

    private CommandGateway commandGateway;

    @Override
    public CompleteFuture<String> placeOrder() {
//        return commandGateway.send(new OrderStockCommand());
        return null;
    }
}
