// src/main/java/com/miapi/apiventas/v1/controllers/AuthController.java
package com.miapi.apiventas.v1.controllers;

import com.miapi.apiventas.shared.dtos.requests.LoginRequest;
import com.miapi.apiventas.shared.dtos.responses.JwtResponse;

import lombok.RequiredArgsConstructor;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;

    // The constructor is generated automatically by @RequiredArgsConstructor

    @PostMapping("/login")
    public JwtResponse login(@RequestBody LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                request.username(),
                request.password()
            )
        );

        User user = (User) authentication.getPrincipal();
        
        return new JwtResponse(
            "TuClaveSecretaMuySeguraYCompleja1234567890!@#", // Implementar generación real de JWT
            user.getUsername(),
            user.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .toList()
        );
    }
}