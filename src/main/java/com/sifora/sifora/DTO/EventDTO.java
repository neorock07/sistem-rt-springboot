package com.sifora.sifora.DTO;

import java.util.Date;

import com.sifora.sifora.Entity.Role;

import lombok.Data;

@Data
public class EventDTO {
    private Long id;
    // private Role role;
    private String title;
    private String image; 
    private String deskripsi;
    private String lokasi;
    private Date date;
    private String penyelenggara;

}
