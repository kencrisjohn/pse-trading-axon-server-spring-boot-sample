package com.elpspy.psetrading.ordermanagement.services.commands;

import io.netty.util.concurrent.CompleteFuture;

public interface OrderManagementService {

    CompleteFuture<String> placeOrder();

}
