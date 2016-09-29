package biz.bsoft.orders.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by vbabin on 30.08.2016.
 */
@RestController
@RequestMapping("/users")
public class UserRestController {
    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }

}
