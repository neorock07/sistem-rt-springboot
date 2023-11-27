package com.sifora.sifora.DTO;

import java.io.Serializable;

import lombok.Data;

@Data
public class RegisterDTO implements Serializable {
    
    private String id;
    private String username;
    private String email;
    private String password;

}
