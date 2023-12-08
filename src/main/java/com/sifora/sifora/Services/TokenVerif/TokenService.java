package com.sifora.sifora.Services.TokenVerif;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sifora.sifora.Entity.Token;
import com.sifora.sifora.Repository.RepoToken;

@Service
public class TokenService {
    
    @Autowired
    RepoToken repo;

    public Token save(String token){
        Token tok = new Token();
        tok.setToken(token);
        return repo.save(tok);
    }

    public List<Token> findByToken(){
        return repo.findAll();
    }
}
