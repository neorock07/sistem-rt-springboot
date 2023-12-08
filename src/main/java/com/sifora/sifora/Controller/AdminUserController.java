package com.sifora.sifora.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sifora.sifora.Entity.User;
import com.sifora.sifora.Jwt.Services.JwtServices;
import com.sifora.sifora.Services.Admin.AdminUserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class AdminUserController {

    @Autowired
    AdminUserService serv;

    @GetMapping()
    public List<User> getUsers() {

        return serv.findAll();
    }

}
