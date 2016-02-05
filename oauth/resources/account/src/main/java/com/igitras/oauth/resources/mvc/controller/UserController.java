package com.igitras.oauth.resources.mvc.controller;

import com.igitras.oauth.common.model.entity.User;
import com.igitras.oauth.common.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mason
 */
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/users")
    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }
}
