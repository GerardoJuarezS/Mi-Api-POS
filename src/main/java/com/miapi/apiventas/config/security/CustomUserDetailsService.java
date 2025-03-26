// src/main/java/com/miapi/apiventas/config/security/CustomUserDetailsService.java
package com.miapi.apiventas.config.security;

import com.miapi.apiventas.domain.models.UsuarioModel;
import com.miapi.apiventas.infrastructure.repositories.UsuarioRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    public CustomUserDetailsService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsuarioModel usuarioModel = usuarioRepository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
        
        return User.builder()
            .username(usuarioModel.getUsername())
            .password(usuarioModel.getPassword())
            .roles(usuarioModel.getRoles().toArray(new String[0]))
            .build();
    }
}