package com.digitalbanking.accountservice.security;

import lombok.Getter;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("auth")
public class WebSecurityController {

    @GetMapping("/principal")
    public Map<?, ?> getPrincipal(Authentication authentication) {
        return Map.of(
                "roles", authentication.getAuthorities().stream()
                        .map(Object::toString)
                        .toList(),
                "username", authentication.getCredentials()
        );
    }
}
