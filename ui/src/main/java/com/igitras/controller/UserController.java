package com.igitras.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Collections;
import java.util.Map;

/**
 * @author mason
 */
@RestController
public class UserController {
    @RequestMapping("/user")
    public Map<String, String> user(Principal user) {
        return Collections.singletonMap("name", user.getName());
    }
}
