package biz.bsoft.orders.persistence.dao;

import biz.bsoft.orders.persistence.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by vbabin on 30.08.2016.
 */
public interface RoleRepository extends JpaRepository<Role,Long>{
    Role findByName(String name);
}
