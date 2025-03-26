package com.miapi.apiventas.v1.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miapi.apiventas.application.services.CategoriaService;
import com.miapi.apiventas.shared.dtos.requests.CategoriaRequest;
import com.miapi.apiventas.shared.dtos.responses.CategoriaResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/categorias")
@RequiredArgsConstructor
public class CategoriaController {
    private final CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<CategoriaResponse> createCategoria(
            @Valid @RequestBody CategoriaRequest request) {
        CategoriaResponse response = categoriaService.createCategoria(request);
        return ResponseEntity.status(Response.SC_CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaResponse> getCategoriaById(@PathVariable Long id) {
        return ResponseEntity.ok(categoriaService.getCategoriaById(id));
    }
}
