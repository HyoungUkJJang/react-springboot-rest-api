package com.prgrms.kdtspringwork.controller.api;

import com.prgrms.kdtspringwork.model.OrderItem;
import java.util.List;

public record CreateOrderRequest(String email, String address, String postcode, List<OrderItem> orderItems) {

}
