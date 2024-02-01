package com.taguo.petpets.config;

import java.awt.RenderingHints.Key;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {


//    private static final String SECRET_KEY = "Taguopetpets2024";  // JWT密鑰
    private static final SecretKey SECRET_KEY = MacProvider.generateKey(SignatureAlgorithm.HS512);

    // 生成JWT令牌
    public static String generateToken(Long loginId,String email){
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + 3600000*24);  // 有效期1天

        return Jwts.builder()
                .claim("email", email)
                .setSubject(String.valueOf(loginId))
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SECRET_KEY)
                .compact();
    }

    // 解析JWT令牌
    public static Claims parseToken(String token){
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }
}
