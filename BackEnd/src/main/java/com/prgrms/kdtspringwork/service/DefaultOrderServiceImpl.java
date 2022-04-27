package com.prgrms.kdtspringwork.service;

import com.prgrms.kdtspringwork.model.Email;
import com.prgrms.kdtspringwork.model.Order;
import com.prgrms.kdtspringwork.model.OrderItem;
import com.prgrms.kdtspringwork.model.OrderStatus;
import com.prgrms.kdtspringwork.repository.OrderRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class DefaultOrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public DefaultOrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order createOrder(Email email, String address, String postcode, List<OrderItem> orderItems) {
        Order order = new Order(UUID.randomUUID(), email, address, postcode, orderItems,
            OrderStatus.ACCEPTED, LocalDateTime.now(), LocalDateTime.now());
        Order insertOrder = orderRepository.insert(order);
        return insertOrder;
    }

}
