package com.miapi.apiventas.domain.models;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Table(name = "categorias")
@Builder
public class CategoriaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Correct annotation and strategy
    private Long id;

    @NotBlank
    @Size(max = 100)
    @Column(unique = true)
    private String nombre;

    @Size(max = 255)
    private String descripcion;

    @CreationTimestamp
    private LocalDateTime fechaCreacion;
}