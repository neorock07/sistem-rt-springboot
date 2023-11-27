package com.sifora.sifora.Jwt.Services;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.sifora.sifora.Entity.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtServicesImpl implements JwtServices {

    @Value("${jwt.expirationMs}")
    private int jwtExpirationMs;

    @Value("${jwt.secret}")
    private String jwtKey;

    public String generateToken(UserDetails userDetails) {
        return Jwts.builder().setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs))
                .signWith(getSignedKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    private <T> T getClaims(String token, Function<Claims, T> claimResolver) {
        final Claims claim = getAllClaims(token);
        return claimResolver.apply(claim);
    }

    private Claims getAllClaims(String token) {
        return Jwts.parserBuilder().setSigningKey(getSignedKey()).build().parseClaimsJws(token).getBody();
    }

    public String getUsernameFromJwtToken(String token) {
        return getClaims(token, Claims::getSubject);
    }

    private Key getSignedKey() {
        byte[] keyBytes = Decoders.BASE64.decode(jwtKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = getUsernameFromJwtToken(token);
        return (username.equals(userDetails.getUsername()) && !isExpiredToken(token));

    }

    private boolean isExpiredToken(String token) {
        return getClaims(token, Claims::getExpiration).before(new Date());
    }

    public String generateRefreshToken(HashMap<String, Object> claim, UserDetails userDetails) {
        return Jwts.builder().setClaims(claim).setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs))
                .signWith(getSignedKey(), SignatureAlgorithm.HS256)
                .compact();
    }
}
