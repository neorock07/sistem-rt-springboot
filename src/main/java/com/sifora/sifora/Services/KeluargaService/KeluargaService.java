package com.sifora.sifora.Services.KeluargaService;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sifora.sifora.DTO.KeluargaDTO;
import com.sifora.sifora.Entity.Anggota;
import com.sifora.sifora.Entity.Keluarga;
import com.sifora.sifora.Repository.RepoKeluarga;

@Service
public class KeluargaService {
    
    @Autowired
    RepoKeluarga repo;

    public Keluarga create(KeluargaDTO req){
        Keluarga kel = new Keluarga();
        kel.setId(req.getId());  
        return repo.save(kel);
    }

    public List<KeluargaDTO> findAll(){
        List<Keluarga> listKeluarga = repo.findAll();
        return listKeluarga.stream()
                .map(kel -> new KeluargaDTO(
                    kel.getId(),
                    kel.getAnggota().stream().map(
                        Anggota::getId
                    ).collect(Collectors.toList()))).collect(Collectors.toList());
    }

    public Keluarga findById(String id){
        return repo.findById(id).orElseThrow();
    }


}
