package com.sifora.sifora.Entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "Anggota")
public class Anggota implements Serializable{
    
    @Id
    private String id;
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "keluarga_id", referencedColumnName = "id")
    private Keluarga keluarga_id;
    
    // @OneToOne
    // @JoinColumn(name = "user_id", referencedColumnName = "id")
    // private User user_id;

    @Column(name = "nama",length = 50)
    private String nama;

    @Column(name = "no_telp", length = 12)
    private String no_telp;

    @Column(name = "tgl_lahir")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date tgl_lahir;

    @Column(name = "tempat_lahir", length = 50)
    private String tempat_lahir;

    @Column(name="jenis_kelamin", length = 1)
    private String jenis_kelamin;
    
    @Column(name="pekerjaan", length = 20)
    private String pekerjaan;
    
    @Column(name="status_kawin", length = 20)
    private String status_kawin;

    @Column(name="bangsa", length = 3)
    private String bangsa;

    @Column(name="negara", length = 20)
    private String negara;
    
    @Column(name="prov", length = 20)
    private String prov;
    
    @Column(name="kota", length = 25)
    private String kota;
    
    @Column(name="kecamatan", length = 25)
    private String kecamatan;
    
    @Column(name="alamat", length = 25)
    private String alamat;
}

