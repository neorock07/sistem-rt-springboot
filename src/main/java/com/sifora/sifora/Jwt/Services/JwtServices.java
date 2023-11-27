package com.sifora.sifora.Jwt.Services;

import java.util.HashMap;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtServices {
    
    String getUsernameFromJwtToken(String token);
    String generateToken(UserDetails userDetails);
    public boolean isTokenValid(String token, UserDetails userDetails);
    public String generateRefreshToken(HashMap<String, Object> claim, UserDetails userDetails);

}
