package com.sifora.sifora.Entity;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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

    @jakarta.persistence.Id
    private String id;

    @JsonIgnoreProperties("keluarga")
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "keluarga_id", cascade = CascadeType.ALL)
    private List<Anggota> anggota;

    
}
