package com.sifora.sifora.Entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "User")
@Data
public class User implements UserDetails {
  
  @Id
  private String id;

  @Column(name = "username", length = 30)
  private String username;

  @Column(name = "email", unique = true, length = 50)
  private String email;

  @Column(name = "password")
  private String password;

  private Role role;

  @OneToOne
  private Anggota anggota_id;

  public User(String id, String username, String email, String password, Role role){
    this.id = id;
    this.username = username;
    this.password = password;
    this.email = email;
    this.role = role;
}

@Override
public Collection<? extends GrantedAuthority> getAuthorities() {
    return List.of(new SimpleGrantedAuthority(role.name()));
}

@Override
public boolean isAccountNonExpired() {
    return true;
}

@Override
public boolean isAccountNonLocked() {
    return true;
}

@Override
public boolean isCredentialsNonExpired() {
    return true;
}

@Override
public boolean isEnabled() {
    return true;
}

@Override
public String getPassword() {
    return password;
}

@Override
public String getUsername() {
    return email;
}

 
}

