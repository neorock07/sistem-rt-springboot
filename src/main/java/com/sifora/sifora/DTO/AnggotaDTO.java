package com.sifora.sifora.DTO;

import java.io.Serializable;
import java.util.Date;

import com.sifora.sifora.Entity.Keluarga;
import com.sifora.sifora.Entity.User;

import lombok.Data;

@Data
public class AnggotaDTO implements Serializable {

    private String id;
    // private String user_id;
    // private User user_id;
    private String nama;
    private String no_telp;
    private Keluarga keluarga_id;
    // private String keluarga_id;
    private Date tgl_lahir;
    private String tempat_lahir;
    private String jenis_kelamin;
    private String pekerjaan;
    private String bangsa;
    private String negara;
    private String prov;
    private String kota;
    private String kecamatan;
    private String alamat;
    private String status_kawin;
}
