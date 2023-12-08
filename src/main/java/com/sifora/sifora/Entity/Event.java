package com.sifora.sifora.Entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "Event")
public class Event implements Serializable {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @ManyToOne
    // @JoinColumn(name = "role_id", referencedColumnName = "id")
    // private Role role;

    @Column(name="title")
    private String title;

    @Column(name = "image")
    private String image; 

    @Column(name = "deskripsi")
    private String deskripsi;
    
    @Column(name = "lokasi")
    private String lokasi;
    
    @Column(name = "date")
    private Date date;

    @Column(name = "penyelenggara")
    private String penyelenggara;

    
}
