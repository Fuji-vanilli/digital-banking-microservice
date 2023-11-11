package com.digitalbanking.gatewayservice.security;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

@Validated
@Data
@ConfigurationProperties(prefix = "jwt.auth.converter")
@Configuration
public class JwtAuthConverterProperties {
    private String resourceId;
    private String principalAttribute;
}
