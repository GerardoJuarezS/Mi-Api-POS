// src/main/java/com/miapi/apiventas/application/impl/CategoriaServiceImpl.java
package com.miapi.apiventas.application.impl;

import com.miapi.apiventas.application.services.CategoriaService;
import com.miapi.apiventas.domain.models.CategoriaModel;
import com.miapi.apiventas.infrastructure.repositories.CategoriaRepository;
import com.miapi.apiventas.shared.dtos.requests.CategoriaRequest;
import com.miapi.apiventas.shared.dtos.responses.CategoriaResponse;
import com.miapi.apiventas.domain.exceptions.DuplicateResourceException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;

    @Override
    @Transactional
    public CategoriaResponse createCategoria(CategoriaRequest request) {
        if (categoriaRepository.existsByNombre(request.nombre())) {
            throw new DuplicateResourceException("Ya existe una categoría con ese nombre");
        }

        CategoriaModel categoria = CategoriaModel.builder()
                .nombre(request.nombre())
                .descripcion(request.descripcion())
                .build();

        CategoriaModel saved = categoriaRepository.save(categoria);

        return new CategoriaResponse(
                saved.getId(),
                saved.getNombre(),
                saved.getDescripcion(),
                saved.getFechaCreacion());
    }

    @Override
    public List<CategoriaResponse> getAllCategorias() {
        return categoriaRepository.findAll().stream()
                .map(c -> new CategoriaResponse(
                        c.getId(),
                        c.getNombre(),
                        c.getDescripcion(),
                        c.getFechaCreacion()))
                .toList();
    }

    @Override
    public CategoriaResponse getCategoriaById(Long id) {
        return categoriaRepository.findById(id)
                .map(c -> new CategoriaResponse(
                        c.getId(),
                        c.getNombre(),
                        c.getDescripcion(),
                        c.getFechaCreacion()))
                .orElseThrow(() -> new EntityNotFoundException("Categoría no encontrada"));
    }
}