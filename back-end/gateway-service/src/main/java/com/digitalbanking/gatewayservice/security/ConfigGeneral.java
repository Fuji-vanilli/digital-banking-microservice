package com.digitalbanking.gatewayservice.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;

import java.net.MalformedURLException;
import java.net.URL;

@Configuration
public class ConfigGeneral {
    @Bean
    public JwtGrantedAuthoritiesConverter jwtGrantedConverter() {
        return new JwtGrantedAuthoritiesConverter();
    }
    //@Bean
    public JwtDecoder jwtDecoder() throws MalformedURLException {
        URL jwkSetUri= new URL("http://localhost:8080/realms/banking-realm/protocol/openid-connect/certs");
        return NimbusJwtDecoder.withJwkSetUri(jwkSetUri.toString()).build();
    }
}
