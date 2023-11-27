package com.sifora.sifora.Services.Impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sifora.sifora.Repository.RepoUser;
import com.sifora.sifora.Services.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    
    private final RepoUser repo;

    public UserDetailsService userDetailsService(){
        return new UserDetailsService() {

            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
               return repo.findByEmail(username).
               orElseThrow(() -> new UsernameNotFoundException("User " + username + " Not found"));
            }
            
        };
    }
}
