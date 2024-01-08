package com.sifora.sifora.Entity;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Lob;
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
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    // @ManyToOne
    // @JoinColumn(name = "role_id", referencedColumnName = "id")
    // private Role role;

    @Column(name="title")
    private String title;

    @Column(name = "fileName")
    private String fileName; 
    
    @Column(name = "fileType")
    private String fileType;
    
    @Lob
    private byte[] data;

    @Column(name = "deskripsi")
    private String deskripsi;
    
    @Column(name = "lokasi")
    private String lokasi;
    
    @Column(name = "date")
    private Date date;

    @Column(name = "penyelenggara")
    private String penyelenggara;

    public Event(String fileName, String fileType, byte[] data){
        this.fileName = fileName;
        this.data = data;
        this.fileType = fileType;
    }
}
