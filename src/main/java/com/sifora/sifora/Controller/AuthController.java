package com.sifora.sifora.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sifora.sifora.DTO.JwtResponse;
import com.sifora.sifora.DTO.LoginDTO;
import com.sifora.sifora.DTO.RefreshTokenResponse;
import com.sifora.sifora.DTO.RegisterDTO;
import com.sifora.sifora.Entity.User;
import com.sifora.sifora.Services.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    
    private final AuthService authService;

    // @PostMapping("/register")
    // public ResponseEntity<User> register(@RequestBody RegisterDTO req){
    //     return ResponseEntity.ok(
    //         authService.register(req)
    //     );
    // }
    @PostMapping("/register")
    public ResponseEntity<RegisterDTO> register(@RequestBody RegisterDTO req){
        return ResponseEntity.ok(
            authService.register(req)
        );
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody LoginDTO req){
        return ResponseEntity.ok(
            authService.login(req)
        );
    }

    @PostMapping("/refresh")
    public ResponseEntity<JwtResponse> refreshToken(@RequestBody RefreshTokenResponse req){
        return ResponseEntity.ok(
            authService.refreshToken(req)
        );
    }


}
