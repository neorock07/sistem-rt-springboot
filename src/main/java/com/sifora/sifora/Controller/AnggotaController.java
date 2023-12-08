package com.sifora.sifora.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sifora.sifora.DTO.AnggotaDTO;
import com.sifora.sifora.Entity.Anggota;
import com.sifora.sifora.Services.AnggotaService.AnggotaService;

@RequestMapping("/api/v1/anggota")
@RestController
public class AnggotaController {

    @Autowired
    AnggotaService serv;

    @PostMapping
    public void create(@RequestBody AnggotaDTO req){
        serv.create(req);
    }

    @GetMapping
    public ResponseEntity<List<Anggota>> getAll(){
        return ResponseEntity.ok(serv.findAll());
    }
    
}
