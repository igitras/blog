package com.igitras.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;


/**
 * Created by mason on 1/25/16.
 */
@SpringBootApplication
//@EnableRedisHttpSession
@EnableOAuth2Sso
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    //    @Configuration
    //    @Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
    //    protected static class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    //
    //        @Autowired
    //        public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
    //            auth.inMemoryAuthentication()
    //                    .withUser("user")
    //                    .password("password")
    //                    .roles("USER")
    //                    .and()
    //                    .withUser("admin")
    //                    .password("admin")
    //                    .roles("USER", "ADMIN", "READER", "WRITER")
    //                    .and()
    //                    .withUser("audit")
    //                    .password("audit")
    //                    .roles("USER", "ADMIN", "READER");
    //        }
    //
    //        @Override
    //        protected void configure(HttpSecurity http) throws Exception {
    //            http.httpBasic()
    //                    .and()
    //                    .logout()
    //                    .and()
    //                    .authorizeRequests()
    //                    .antMatchers("/index.html", "/login", "/")
    //                    .permitAll()
    //                    .anyRequest()
    //                    .authenticated()
    //                    .and()
    //                    .csrf()
    //                    .csrfTokenRepository(csrfTokenRepository())
    //                    .and()
    //                    .addFilterAfter(new CsrfHeaderFilter(), CsrfFilter.class);
    //        }
    //
    //        private CsrfTokenRepository csrfTokenRepository() {
    //            HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
    //            repository.setHeaderName("X-XSRF-TOKEN");
    //            return repository;
    //        }
    //    }
}
