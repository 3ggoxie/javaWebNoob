package org.example.javawebnoob;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

//@SpringBootTest

class JavaWebNoobApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void testUuid() {
        for (int i = 0; i < 1000; i++) {
            String uuid = UUID.randomUUID().toString();
            System.out.println(uuid);
        }
    }

    @Test
    public void testGenJwt() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", 1);
        claims.put("username", "admin");

        String jwt = Jwts.builder().signWith(SignatureAlgorithm.HS256,
                        "ssgJwre05swrtLtSe01c0CkIe051tLtsllIsgJ2031sgJwre051tLtSe01c0CkIllI203Se01c0CkIllI203")//签名算法和密钥
                .setClaims(claims)//自定义内容（载荷）
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))//设置有效期为1小时
                .compact();
        System.out.println(jwt);
    }

    @Test
    public void testParseJwt() {
        String jwt = "eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwidXNlcm5hbWUiOiJhZG1pbiIsImV4cCI6MTcyNTk1ODUwMX0" +
                ".Fk1Ot3Fj5sU4qFkPKlMzHQhRKF78ljAaEGKPz85XsrA";
        Claims claims = Jwts.parser().setSigningKey(
                "ssgJwre05swrtLtSe01c0CkIe051tLtsllIsgJ2031sgJwre051tLtSe01c0CkIllI203Se01c0CkIllI203").parseClaimsJws(jwt).getBody();
        System.out.println(claims);
    }
}

