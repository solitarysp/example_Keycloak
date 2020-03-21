package com.lethanh98.keycloak.config;

import org.keycloak.adapters.KeycloakDeployment;
import org.keycloak.adapters.KeycloakDeploymentBuilder;
import org.keycloak.adapters.spi.HttpFacade;
import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.keycloak.adapters.springboot.KeycloakSpringBootProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author thanhnd44
 * Viettel @2017 Confidential and Proprietary
 * Created on 10/09/2019
 */
@Configuration
public class MyKeycloakSpringBootConfigResolver extends KeycloakSpringBootConfigResolver {

    private final KeycloakSpringBootProperties properties;

    private KeycloakDeployment keycloakDeployment;

    public MyKeycloakSpringBootConfigResolver(KeycloakSpringBootProperties properties) {
        this.properties = properties;
    }

    @Override
    public KeycloakDeployment resolve(HttpFacade.Request facade) {
        if (keycloakDeployment != null) {
            return keycloakDeployment;
        }

        keycloakDeployment = KeycloakDeploymentBuilder.build(properties);
        return keycloakDeployment;
    }
}
