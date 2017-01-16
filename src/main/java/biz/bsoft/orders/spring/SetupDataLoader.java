package biz.bsoft.orders.spring;

import biz.bsoft.orders.persistence.dao.OrderRepository;
import biz.bsoft.orders.persistence.dao.PrivilegeRepository;
import biz.bsoft.orders.persistence.dao.RoleRepository;
import biz.bsoft.orders.persistence.dao.UserRepository;
import biz.bsoft.orders.persistence.model.Order;
import biz.bsoft.orders.persistence.model.Privilege;
import biz.bsoft.orders.persistence.model.Role;
import biz.bsoft.orders.persistence.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by vbabin on 30.08.2016.
 */
@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private boolean alreadySetup = false;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PrivilegeRepository privilegeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    OrderRepository orderRepository;

    // API

    @Override
    @Transactional
    public void onApplicationEvent(final ContextRefreshedEvent event) {
        if (alreadySetup) {
            return;
        }

        // == create initial privileges
        final Privilege readPrivilege = createPrivilegeIfNotFound("READ_PRIVILEGE");
        final Privilege writePrivilege = createPrivilegeIfNotFound("WRITE_PRIVILEGE");

        // == create initial roles
        final List<Privilege> adminPrivileges = Arrays.asList(readPrivilege, writePrivilege);
        createRoleIfNotFound("ROLE_ADMIN", adminPrivileges);
        createRoleIfNotFound("ROLE_USER", Arrays.asList(readPrivilege));

        final Role adminRole = roleRepository.findByName("ROLE_ADMIN");
        final User user = new User();
        user.setFirstName("Test");
        user.setLastName("Test");
        user.setPassword(passwordEncoder.encode("1"));
        user.setEmail("q");
        user.setRoles(Arrays.asList(adminRole));
        user.setEnabled(true);
        userRepository.save(user);

        //Test order
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        //
        Order order = new Order();
        order.setId(52356);
        order.setClient("Client 1");
        order.setClientId(123);
        order.setClientPos("Client1 pos1");
        order.setClientPosId(124);
        order.setRoute("Center");
        order.setRouteId(5);
        LocalDate date = LocalDate.parse("01.10.2017",format);
        order.setShipDate(date);
        orderRepository.save(order);
        //Test order2
        order = new Order();
        order.setId(52350);
        order.setClient("Client 1");
        order.setClientId(123);
        order.setClientPos("Client1 pos2");
        order.setClientPosId(124);
        order.setRoute("Center");
        order.setRouteId(5);
        date = LocalDate.parse("01.10.2017",format);
        order.setShipDate(date);
        orderRepository.save(order);
        //Test order3
        order = new Order();
        order.setId(52250);
        order.setClient("Client 1");
        order.setClientId(123);
        order.setClientPos("Client1 pos2");
        order.setClientPosId(124);
        order.setRoute("Center");
        order.setRouteId(5);
        date = LocalDate.parse("02.10.2017",format);
        order.setShipDate(date);
        orderRepository.save(order);

        alreadySetup = true;
    }

    @Transactional
    private final Privilege createPrivilegeIfNotFound(final String name) {
        Privilege privilege = privilegeRepository.findByName(name);
        if (privilege == null) {
            privilege = new Privilege(name);
            privilegeRepository.save(privilege);
        }
        return privilege;
    }

    @Transactional
    private final Role createRoleIfNotFound(final String name, final Collection<Privilege> privileges) {
        Role role = roleRepository.findByName(name);
        if (role == null) {
            role = new Role(name);
            role.setPrivileges(privileges);
            roleRepository.save(role);
        }
        return role;
    }
}
