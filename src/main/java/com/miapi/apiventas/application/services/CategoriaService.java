package com.miapi.apiventas.application.services;

import java.util.List;

import com.miapi.apiventas.shared.dtos.requests.CategoriaRequest;
import com.miapi.apiventas.shared.dtos.responses.CategoriaResponse;

public interface CategoriaService {
    CategoriaResponse createCategoria(CategoriaRequest categoriaRequest);
    List<CategoriaResponse> getAllCategorias();
    CategoriaResponse getCategoriaById(Long id);
}
