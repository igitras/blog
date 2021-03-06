package com.igitras.auth.configuration;

import com.igitras.auth.service.CustomClientDetailService;
import com.igitras.auth.service.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import java.security.KeyPair;

/**
 * Created by mason on 1/27/16.
 */
@Configuration
@EnableAuthorizationServer
public class AuthServerConfiguration extends AuthorizationServerConfigurerAdapter {
    public static final String KEYSTORE = "igitras.jks";
    public static final String STORE_PASS = "igitrasStorePass";
    public static final String ALIAS = "igitrasKey";
    public static final String ALIAS_PASS = "igitrasPass";

    @Autowired
    private CustomClientDetailService clientDetailService;

    @Autowired
    private CustomUserDetailService userDetailService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisConnectionFactory connectionFactory;

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();

        KeyPair keyPair =
                new KeyStoreKeyFactory(new ClassPathResource(KEYSTORE), STORE_PASS.toCharArray()).getKeyPair(ALIAS,
                        ALIAS_PASS.toCharArray());
        converter.setKeyPair(keyPair);
        return converter;
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(clientDetailService);
//                .and()
//                .inMemory()
//                .withClient("acme")
//                .secret("acmesecret")
//                .authorizedGrantTypes("authorization_code", "refresh_token", "password")
//                .scopes("openid");
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(new RedisTokenStore(connectionFactory))
                .authenticationManager(authenticationManager)
                .userDetailsService(userDetailService)
                .accessTokenConverter(jwtAccessTokenConverter());
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        oauthServer.checkTokenAccess("permitAll")
                .allowFormAuthenticationForClients();
    }

}
