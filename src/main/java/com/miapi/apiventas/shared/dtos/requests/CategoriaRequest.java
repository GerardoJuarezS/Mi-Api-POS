package com.miapi.apiventas.shared.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CategoriaRequest(
        @NotBlank(message = "El nombre es obligatorio") @Size(max = 100, message = "El nombre no puede tener más de 100 caracteres") String nombre,

        @Size(max = 255, message = "La descripción no puede tener más de 255 caracteres") String descripcion) {
}
