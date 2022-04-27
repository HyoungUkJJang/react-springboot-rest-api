package com.prgrms.kdtspringwork.service;

import com.prgrms.kdtspringwork.model.Email;
import com.prgrms.kdtspringwork.model.Order;
import com.prgrms.kdtspringwork.model.OrderItem;
import java.util.List;

public interface OrderService {

    Order createOrder(Email email, String address, String postcode, List<OrderItem> orderItems);

}
