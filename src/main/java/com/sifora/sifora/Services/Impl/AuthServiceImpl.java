package com.sifora.sifora.Services.Impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sifora.sifora.DTO.JwtResponse;
import com.sifora.sifora.DTO.LoginDTO;
import com.sifora.sifora.DTO.RefreshTokenResponse;
import com.sifora.sifora.DTO.RegisterDTO;
import com.sifora.sifora.Entity.Role;
import com.sifora.sifora.Entity.User;
import com.sifora.sifora.Jwt.Services.JwtServices;
import com.sifora.sifora.Repository.RepoUser;
import com.sifora.sifora.Services.AuthService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    
    @Autowired
    private final RepoUser repo;

    @Autowired
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private final AuthenticationManager authManager;

    private final JwtServices jwtServices;

    public User register(RegisterDTO req){
        User user = new User();
        
        user.setId(req.getId());
        user.setEmail(req.getEmail());
        user.setUsername(req.getUsername());
        user.setPassword(passwordEncoder.encode(req.getPassword()));
        user.setRole(Role.ADMIN);

        return repo.save(user);
    }

    public JwtResponse login(LoginDTO req){
        authManager.authenticate(new UsernamePasswordAuthenticationToken(req.getEmail(), req.getPassword()));
        var user = repo.findByEmail(req.getEmail()).orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));
        var jwt = jwtServices.generateToken(user);
        var refreshToken = jwtServices.generateRefreshToken(new HashMap<>(), user);
        
        JwtResponse response = new JwtResponse();
        response.setToken(jwt);
        response.setRefreshToken(refreshToken);
        return response;
    }

    public JwtResponse refreshToken(RefreshTokenResponse ref){
        String email = jwtServices.getUsernameFromJwtToken(ref.getToken());
        User user = repo.findByEmail(email).orElseThrow();
        if(jwtServices.isTokenValid(ref.getToken(), user)){
            var jwt = jwtServices.generateToken(user);

            JwtResponse response = new JwtResponse();
            response.setToken(jwt);
            response.setRefreshToken(ref.getToken());
            return response;
        }
        return null;
    }


    public List<User> findAll(){
        return repo.findAll();
    }


}
