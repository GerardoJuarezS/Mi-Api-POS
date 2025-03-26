// src/main/java/com/miapi/apiventas/shared/dtos/requests/LoginRequest.java
package com.miapi.apiventas.shared.dtos.requests;

public record LoginRequest(
    String username,
    String password
) {}