package com.miapi.apiventas.shared.dtos.responses;

import java.time.LocalDateTime;

public record CategoriaResponse(
        Long id,
        String nombre,
        String descripcion,
        LocalDateTime fechaCreacion) {

}
