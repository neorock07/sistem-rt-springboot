package com.sifora.sifora.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sifora.sifora.DTO.KeluargaDTO;
import com.sifora.sifora.Entity.Keluarga;
import com.sifora.sifora.Services.KeluargaService.KeluargaService;

@RequestMapping("/api/v1/keluarga")
@RestController
public class KeluargaController {
    
    @Autowired
    KeluargaService serv;

    @PostMapping()
    public Keluarga create(@RequestBody KeluargaDTO req){
        return serv.create(req);
    }

    @GetMapping()
    public List<KeluargaDTO> getAll(){
        return serv.findAll();
    }

    @GetMapping("/{id}")
    public Keluarga findById(@PathVariable String id){
        return serv.findById(id);
    }


}
