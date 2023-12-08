package com.sifora.sifora.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sifora.sifora.Entity.Anggota;

@Repository
public interface RepoAnggota extends JpaRepository<Anggota, String> {
}
