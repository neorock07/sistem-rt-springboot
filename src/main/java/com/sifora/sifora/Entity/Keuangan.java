package com.sifora.sifora.Entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Entity
@Table(name="Keuangan")
public class Keuangan implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private Long id;

    // @ManyToOne
    // @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role role;

    @Column(name = "nominal")
    private int nominal;

    @Column(name = "date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "kategori_id", referencedColumnName = "id")
    private Kategori kategori_id;
}
