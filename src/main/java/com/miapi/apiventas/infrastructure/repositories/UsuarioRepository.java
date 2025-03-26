// src/main/java/com/miapi/apiventas/infrastructure/repositories/UsuarioRepository.java
package com.miapi.apiventas.infrastructure.repositories;

import com.miapi.apiventas.domain.models.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
    Optional<UsuarioModel> findByUsername(String username);
}