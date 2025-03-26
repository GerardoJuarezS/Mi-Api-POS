package com.miapi.apiventas.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miapi.apiventas.domain.models.CategoriaModel;


public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long> {
    boolean existsByNombre(String nombre); // Declarar el método aquí
}
