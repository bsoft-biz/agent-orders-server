package biz.bsoft.orders.service;

import biz.bsoft.orders.web.dto.OrderDto;

import java.util.List;

public interface OrderService {
    void processOrders(List<OrderDto> orders);
}
