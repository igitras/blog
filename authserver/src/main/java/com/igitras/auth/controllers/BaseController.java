package com.igitras.auth.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.security.Principal;

/**
 * @author mason
 */
@SessionAttributes("authorizationRequest")
@RestController
public class BaseController {

    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }
}
