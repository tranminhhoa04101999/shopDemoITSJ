package com.example.shopdemoitsj.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class JwtTokenProvider {
  private final String JWT_SECRET = "minhhoa";
  private final long JWT_EXPIRATION = 1800000;

  public String generateToken(CustomUserDetails userDetails) {
    // Lấy thông tin user
    Date now = new Date();
    Date expiryDate = new Date(now.getTime() + JWT_EXPIRATION);
    // Tạo chuỗi json web token từ id của user.
    return Jwts.builder()
        .setSubject((userDetails.getCustomer().getUsername()))
        .setIssuedAt(now)
        .setExpiration(expiryDate)
        .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
        .compact();
  }

  public String getUserIdFromJWT(String token) {
    Claims claims = Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token).getBody();

    return String.valueOf(claims.getSubject());
  }

  public boolean validateToken(String authToken) {
    try {
      Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(authToken);
      return true;
    } catch (MalformedJwtException ex) {
      log.error("Invalid JWT token");
    } catch (ExpiredJwtException ex) {
      log.error("Expired JWT token");
    } catch (UnsupportedJwtException ex) {
      log.error("Unsupported JWT token");
    } catch (IllegalArgumentException ex) {
      log.error("JWT claims string is empty.");
    }
    return false;
  }
}
