package com.igitras.auth.domain.entity;

import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.security.oauth2.provider.endpoint.AbstractEndpoint;

import javax.persistence.Entity;

/**
 * @author mason
 */
@Entity
public class Client extends AbstractPersistable<Long> {
    private String clientId;
    private String clientSecret;
    private String resourceIds;
    private String scope;
    private String authorizedGrantTypes;
    private String webServerRedirectUri;
    private String authorities;
    private Integer accessTokenValidity;
    private Integer refreshTokenValidity;
    private String additionalInformation;
    private String autoApprove;



}
