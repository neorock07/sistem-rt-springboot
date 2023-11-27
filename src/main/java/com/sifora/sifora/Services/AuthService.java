package com.sifora.sifora.Services;

import com.sifora.sifora.DTO.JwtResponse;
import com.sifora.sifora.DTO.LoginDTO;
import com.sifora.sifora.DTO.RefreshTokenResponse;
import com.sifora.sifora.DTO.RegisterDTO;
import com.sifora.sifora.Entity.User;

public interface AuthService {
    public User register(RegisterDTO req);

    public JwtResponse login(LoginDTO req);

    public JwtResponse refreshToken(RefreshTokenResponse ref);
}
