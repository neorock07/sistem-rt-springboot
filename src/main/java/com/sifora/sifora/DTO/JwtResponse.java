package com.sifora.sifora.DTO;

import lombok.Data;

@Data
public class JwtResponse {
    
    private String token;
    private String refreshToken;
}
