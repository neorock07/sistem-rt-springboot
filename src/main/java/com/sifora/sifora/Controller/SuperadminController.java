package com.sifora.sifora.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sifora.sifora.Entity.User;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/superadmin")
@RequiredArgsConstructor
public class SuperadminController {
    
    @GetMapping()
    public ResponseEntity<String> say() {
       return ResponseEntity.ok("Hi superadmin");
    }
}
