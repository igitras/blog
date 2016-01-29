package com.igitras.resources;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * Created by mason on 1/26/16.
 */
@SpringBootApplication
@EnableResourceServer
public class Application extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic()
                .disable();
        http.authorizeRequests()
                .antMatchers(HttpMethod.POST, "/**")
                .hasRole("WRITER")
                .anyRequest()
                .authenticated();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
