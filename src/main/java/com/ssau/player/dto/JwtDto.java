package com.ssau.player.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class JwtDto {
    private final String id;
    private final String username;
    private final String email;
    private final String jwt;
    private final String role;
}
