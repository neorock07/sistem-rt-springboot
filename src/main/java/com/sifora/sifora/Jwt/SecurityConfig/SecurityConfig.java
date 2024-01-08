package com.sifora.sifora.Jwt.SecurityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.sifora.sifora.Entity.Role;
import com.sifora.sifora.Jwt.jwtConfig.JwtAuthFilter;
import com.sifora.sifora.Services.UserService;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig{
    
    private final JwtAuthFilter authFilter;
    private final UserService userService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.csrf(
            AbstractHttpConfigurer::disable
        ).authorizeHttpRequests(
            req -> req.requestMatchers("/api/v1/auth/**")
                    .permitAll()
                    // .requestMatchers("/api/events/**").permitAll()
                    // .requestMatchers("/api/v1/superadmin").hasAnyAuthority(Role.SUPERADMIN.name())
                    .requestMatchers("/api/v1/**").permitAll()
                    .anyRequest().authenticated()
        ).sessionManagement(
            manager -> manager.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        ).authenticationProvider(
            authProvider()
        ).addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class);


        return http.build();
    }

    @Bean
    public AuthenticationProvider authProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userService.userDetailsService());
        authenticationProvider.setPasswordEncoder(PasswordEncoder());
        return authenticationProvider;
    }

    @Bean
    public PasswordEncoder PasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception{
        return config.getAuthenticationManager();
    }
}
