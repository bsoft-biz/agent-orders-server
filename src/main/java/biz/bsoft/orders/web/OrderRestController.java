package biz.bsoft.orders.web;

import biz.bsoft.orders.persistence.dao.OrderRepository;
import biz.bsoft.orders.persistence.model.Order;
import biz.bsoft.orders.service.OrderService;
import biz.bsoft.orders.web.dto.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderRestController {
    @Autowired
    OrderService orderService;

    @Autowired
    OrderRepository orderRepository;

    @RequestMapping("/")
    List<Order> getAllOrders(){
        List<Order> orders = orderRepository.findAll();
        return orders;
    }

    @RequestMapping(value = "/process", method = RequestMethod.POST)
    void processOrders(@RequestBody List<OrderDto> orders){
        orderService.processOrders(orders);
    }
}
