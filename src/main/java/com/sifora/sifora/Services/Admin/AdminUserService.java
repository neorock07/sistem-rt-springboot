package com.sifora.sifora.Services.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sifora.sifora.Entity.User;
import com.sifora.sifora.Repository.RepoUser;

@Service
public class AdminUserService {
    
    @Autowired
    RepoUser repo;


    public List<User> findAll(){
        return repo.findAll();
    }

    // public AdminDTO findByEmail(String email){
    //     var opt = repoAdmin.findByEmail(email);
    //     return (opt.isPresent())? opt.get() : opt.orElseThrow(); 
    // }

    // public Optional<User> update(RegisterDTO req){
        
    // }



}
