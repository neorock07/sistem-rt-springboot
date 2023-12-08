package com.sifora.sifora.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sifora.sifora.Entity.Token;
import com.sifora.sifora.Services.TokenVerif.TokenService;

@RequestMapping("/api/v1/token-verif")
@RestController
public class TokenVerifController {
    
    @Autowired
    private TokenService serv;

    @PostMapping
    public ResponseEntity<Token> save(@RequestBody String token){
        return ResponseEntity.ok(serv.save(token));
    }

    @GetMapping
    public ResponseEntity<List<Token>> findAll(){
        return ResponseEntity.ok(serv.findByToken());
    }

}
