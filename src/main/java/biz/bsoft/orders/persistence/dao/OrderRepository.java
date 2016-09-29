package biz.bsoft.orders.persistence.dao;

import biz.bsoft.orders.persistence.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by vbabin on 01.09.2016.
 */
public interface OrderRepository extends JpaRepository<Order, Integer> {
}
