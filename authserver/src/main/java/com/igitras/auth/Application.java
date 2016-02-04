package com.igitras.auth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author mason
 */
@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.igitras.auth.domain.repository")
public class Application {
    private static final Logger LOG = LoggerFactory.getLogger(Application.class);
    private static final String SERVER_PORT = "server.port";

    public static void main(String[] args) throws UnknownHostException {
        SpringApplication application = new SpringApplication(Application.class);
        ConfigurableEnvironment environment = application.run(args).getEnvironment();
        LOG.info("Access Urls:\n----------------------------------------------------------------------------\n\t"
                        + "Local: http://localhost:{}\n\t" + "External: http://{}:{}/\n"
                        + "----------------------------------------------------------------------------",
                environment.getProperty(SERVER_PORT),
                InetAddress.getLocalHost().getHostAddress(),
                environment.getProperty(SERVER_PORT));

        SpringApplication.run(Application.class, args);
    }
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/login")
//                .setViewName("login");
//        registry.addViewController("/oauth/confirm_access")
//                .setViewName("authorize");
//    }
}
