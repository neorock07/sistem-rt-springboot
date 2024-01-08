package com.sifora.sifora.DTO;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class EventDTO {
    private String id;
    // private Role role;
    private String filename;
    private String fileUrl;
    private String fileType;

    private String title;
    // private String image; 
    private String deskripsi;
    private String lokasi;
    private Date date;
    private String penyelenggara;

    public EventDTO(
        String filename,
        String fileUrl,
        String fileType,
        String title,
        String deskripsi,
        String lokasi,
        Date date,
        String penyelenggara
    ){
        this.filename = filename;
        this.fileUrl = fileUrl;
        this.fileType = fileType;
        this.title = title;
        this.deskripsi = deskripsi;
        this.lokasi = lokasi;
        this.date = date;
        this.penyelenggara = penyelenggara;
    }
}
