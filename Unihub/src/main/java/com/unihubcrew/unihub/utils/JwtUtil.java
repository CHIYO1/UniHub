package com.unihubcrew.unihub.utils;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtil {

    private static final String SECRET_KEY = System.getenv("JWT_SECRET_KEY") != null ?
            System.getenv("JWT_SECRET_KEY") : "MySuperSecureKeyForJWT@2025!UniHub123";
    private static final SecretKey KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private static final long EXPIRATION_TIME = 3 * 60 * 60 * 1000; // 3 hours

    /**
     * 生成令牌：包含 account
     */
    public static String generateToken(String account) {
        return Jwts.builder()
                .subject(account) // 新版用 .subject() 替代 .setSubject()
                .issuedAt(new Date()) // 新版用 .issuedAt() 替代 .setIssuedAt()
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)) // 新版用 .expiration()
                .signWith(KEY) // 直接传入 SecretKey，不再需要算法和 Base64 解码
                .compact();
    }

    /**
     * 从令牌中获取 account
     */
    public static String getAccountFromToken(String token) {
        return parseToken(token).getPayload().getSubject(); // 新版用 getPayload() 替代 getBody()
    }

    /**
     * 验证令牌是否合法
     */
    public static boolean validateToken(String token) {
        try {
            parseToken(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    /**
     * 检查令牌是否过期
     */
    public static boolean isTokenExpired(String token) {
        Date expiration = parseToken(token).getPayload().getExpiration();
        return expiration.before(new Date());
    }

    /**
     * 解析令牌（新版 API）
     */
    private static Jws<Claims> parseToken(String token) {
        return Jwts.parser()
                .verifyWith(KEY) // 新版用 verifyWith() 替代 setSigningKey()
                .build()
                .parseSignedClaims(token); // 新版用 parseSignedClaims() 替代 parseClaimsJws()
    }
}