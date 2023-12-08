package com.sifora.sifora.DTO;

import java.io.Serializable;
import java.util.List;

import com.sifora.sifora.Entity.Anggota;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class KeluargaDTO implements Serializable{
    
    private String id;
    private List<String> anggota;
    // private List<Anggota> anggota_obj;

    

}
