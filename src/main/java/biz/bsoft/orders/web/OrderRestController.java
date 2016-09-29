package biz.bsoft.orders.web;

import biz.bsoft.orders.persistence.dao.OrderRepository;
import biz.bsoft.orders.persistence.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by vbabin on 01.09.2016.
 */
@RestController
@RequestMapping("/orders")
public class OrderRestController {
    @Autowired
    OrderRepository orderRepository;

    @RequestMapping("/")
    List<Order> getAllOrders(){
        List<Order> orders = orderRepository.findAll();
        return orders;
    }
}
