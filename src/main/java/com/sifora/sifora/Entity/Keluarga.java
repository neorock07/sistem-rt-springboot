package com.sifora.sifora.Entity;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "Keluarga")
@AllArgsConstructor
@Data
public class Keluarga implements Serializable{
    
    public Keluarga(){

    }

    public Keluarga(Keluarga kel){
        this.id = kel.getId();
        this.anggota = kel.getAnggota();
    }

    @jakarta.persistence.Id
    private String id;

    @OneToMany(mappedBy = "keluarga_id")
    private List<Anggota> anggota;

    public void setId(Long id2) {
    }
}
