package com.sifora.sifora.DTO;

import com.sifora.sifora.Entity.Role;

import lombok.Data;

@Data
public class JwtResponse {
    private String email;
    private String username;
    private String password;
    private Role role;    
    private String token;
    private String refreshToken;
}
