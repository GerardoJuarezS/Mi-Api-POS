// src/main/java/com/miapi/apiventas/domain/models/Usuario.java
package com.miapi.apiventas.domain.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "usuarios")
public class UsuarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String username;

    @NotBlank
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles;

    @CreationTimestamp
    private LocalDateTime fechaRegistro;
}