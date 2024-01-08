package com.sifora.sifora.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sifora.sifora.Entity.Token;

// import ch.qos.logback.core.subst.Token;

@Repository
public interface RepoToken extends JpaRepository<Token, String> {
    // public Optional<Token> findByToken();   
}
