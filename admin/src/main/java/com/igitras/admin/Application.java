package com.igitras.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author mason
 */
@SpringBootApplication
@EnableRedisHttpSession
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Configuration
    protected static class SecurityConfiguration extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            // @formatter:off
			http
				.httpBasic()
			.and()
				.authorizeRequests()
					.antMatchers("/index.html", "/unauthenticated.html", "/").permitAll()
					.anyRequest().hasRole("ADMIN")
			.and()
				.csrf().disable();
			// @formatter:on
        }
    }
}
