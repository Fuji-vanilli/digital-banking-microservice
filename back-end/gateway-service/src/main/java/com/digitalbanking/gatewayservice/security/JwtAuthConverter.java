package com.digitalbanking.gatewayservice.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtClaimNames;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Configuration
@RequiredArgsConstructor
public class JwtAuthConverter implements Converter<Jwt, AbstractAuthenticationToken> {
    private final JwtAuthConverterProperties jwtAuthConverterProperties;
    private final JwtGrantedAuthoritiesConverter jwtGrantedAuthoritiesConverter;
    @Override
    public AbstractAuthenticationToken convert(Jwt jwt) {
        Collection<GrantedAuthority> authorities= Stream.concat(
                extractRoles(jwt).stream(), Objects.requireNonNull(jwtGrantedAuthoritiesConverter.convert(jwt)).stream()
        ).toList();

        return new JwtAuthenticationToken(jwt, authorities, getPrincipalClaimName(jwt));
    }
    public Collection<? extends GrantedAuthority> extractRoles(Jwt jwt) {
        Map<String, Object> accessResource= jwt.getClaim("resource_access");
        Map<String, Object> resource;
        Collection<String> resourceRoles;

        if (accessResource== null
                || (resource= (Map<String, Object>) accessResource.get(jwtAuthConverterProperties.getResourceId()))== null
                || (resourceRoles= (Collection<String>) resource.get("roles"))== null) {
            return Set.of();
        }

        return resourceRoles.stream()
                .map(role-> new SimpleGrantedAuthority("ROLE_"+role))
                .collect(Collectors.toSet());
    }
    public String getPrincipalClaimName(Jwt jwt) {
        String claimName= JwtClaimNames.SUB;
        if (jwtAuthConverterProperties.getResourceId()!= null) {
            claimName= jwtAuthConverterProperties.getPrincipalAttribute();
        }
        return jwt.getClaim(claimName);
    }

}
