package play.laika.auth2.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

import static java.util.Collections.singletonList;

@Component
public class JwtProvider {

    private static String TOKEN_SECRET = "8d7a3597f9133f09c14bb57a43564be0";
    private static Long TOKEN_TTL_MILLIS = 18_000_000L;

    public String generateToken(String login) {
        Claims claims = Jwts.claims().setSubject(login);
        claims.put("scopes", singletonList("ROLE_USER"));
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + TOKEN_TTL_MILLIS))
                .signWith(SignatureAlgorithm.HS512, TOKEN_SECRET)
                .compact();
    }

    public boolean tokenIsValid(String token) {
        try {
            Jwts.parser().setSigningKey(TOKEN_SECRET).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getLoginFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(TOKEN_SECRET)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}
