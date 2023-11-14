package com.digitalbanking.accountservice.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;

import java.net.MalformedURLException;
import java.net.URL;

@Configuration
public class ConfigGeneral {
    @Bean
    public JwtGrantedAuthoritiesConverter jwtGrantedAuthoritiesConverter() {
        return new JwtGrantedAuthoritiesConverter();
    }
    @Bean
    public JwtDecoder jwtDecoder() throws MalformedURLException {
        return NimbusJwtDecoder.withJwkSetUri(
                new URL("http://localhost:8080/realms/banking-realm/protocol/openid-connect/certs").toString()
        ).build();
    }
}
