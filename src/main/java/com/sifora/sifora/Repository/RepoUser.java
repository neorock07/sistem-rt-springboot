package com.sifora.sifora.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sifora.sifora.Entity.User;

@Repository
public interface RepoUser extends JpaRepository<User, String> {

   public Optional<User> findById(String id);
   public Optional<User> findByEmail(String id);
   public Optional<User> findByUsername(String username);

}   
