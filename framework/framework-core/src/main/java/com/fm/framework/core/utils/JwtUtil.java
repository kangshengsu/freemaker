package com.fm.framework.core.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;

public class JwtUtil {

    private final static String SCRENT = "666666";

    private final static long TOKEN_EXPIRATION = 12 * 3600 * 1000L;

    /**
     * 生成token
     *
     * @param userKey
     * @return token
     */
    public static String generateToken(String userKey) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        SecretKey secretKey = generalKey();
        Date date = new Date(System.currentTimeMillis() + TOKEN_EXPIRATION);
        JwtBuilder jwtBuilder = Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")
                .claim("userKey", userKey)
                .signWith(signatureAlgorithm, secretKey)
                .setExpiration(date);
        return jwtBuilder.compact();
    }

    private static SecretKey generalKey() {
        byte[] encodeKey = Base64.getDecoder().decode(SCRENT);
        SecretKey key = new SecretKeySpec(encodeKey, 0, encodeKey.length, "AES");
        return key;
    }

    /**
     * 解密token 返回payload的信息主体对象claims
     *
     * @param jwtToken token
     * @return Claims
     */
    private static Claims validateJWT(String jwtToken) {
        Claims claims = Jwts.parser()
                .setSigningKey(generalKey())
                .parseClaimsJws(jwtToken).getBody();
        return claims;
    }

    /**
     * 从token中获取key的值
     *
     * @param jwtToken token
     * @param key      key
     * @return value
     */
    public static Object get(String jwtToken, String key) {
        Claims claims = validateJWT(jwtToken);
        String value = claims.get(key, String.class);
        return value;
    }
}
