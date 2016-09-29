package biz.bsoft.orders.persistence.dao;

import biz.bsoft.orders.persistence.model.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by vbabin on 30.08.2016.
 */
public interface PrivilegeRepository extends JpaRepository<Privilege,Long> {
    Privilege findByName(String name);
}
