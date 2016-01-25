package com.igitras.security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import javax.servlet.http.HttpSession;

/**
 * Created by mason on 1/25/16.
 */
@RestController
public class ResourceController {

    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }

}
