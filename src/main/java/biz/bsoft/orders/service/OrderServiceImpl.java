package biz.bsoft.orders.service;

import biz.bsoft.orders.web.dto.OrderDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderServiceImpl implements OrderService {
    private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Override
    public void processOrders(List<OrderDto> orders) {
        logger.info(orders.toString());
    }
}
