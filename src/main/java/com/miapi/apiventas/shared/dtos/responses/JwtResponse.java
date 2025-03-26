package com.miapi.apiventas.shared.dtos.responses;

import java.util.List;

public record JwtResponse(
    String token,
    String username,
    List<String> roles
) {}