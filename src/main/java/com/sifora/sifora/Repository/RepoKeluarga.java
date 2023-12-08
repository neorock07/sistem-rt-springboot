package com.sifora.sifora.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sifora.sifora.DTO.KeluargaDTO;
import com.sifora.sifora.Entity.Keluarga;

@Repository
public interface RepoKeluarga extends JpaRepository<Keluarga, String>{
    
    public KeluargaDTO save(KeluargaDTO req);
    public Optional<Keluarga> findById(String id);
}
