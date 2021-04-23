package play.laika.auth2.config;

import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Component;
import com.auth0.jwt.JWT;

import java.util.Date;

@Component
public class JwtProvider {

    private static String TOKEN_SECRET = "8d7a3597f9133f09c14bb57a43564be0";

    public String generateToken(String login) {
        return JWT.create()
                .withSubject(login)
                .withExpiresAt(new Date(System.currentTimeMillis() + 15_000_000L))
                .sign(Algorithm.HMAC512(TOKEN_SECRET));
    }

    public boolean validateToken(String token) {
        JWT.require(Algorithm.HMAC512(TOKEN_SECRET))
                .build()
                .verify(token)
                .getSubject();
    }
}
