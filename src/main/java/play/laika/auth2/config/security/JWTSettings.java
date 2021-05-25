package play.laika.auth2.config.security;

public class JWTSettings {
    protected static String JWT_SECRET = "8d7a3597f9133f09c14bb57a43564be0";
    protected static Long JWT_TTL_MILLIS = 15_000_000L;
    protected static String BEARER_PREFIX = "Bearer ";
    protected static String AUTHORIZATION_HEADER = "Authorization";
}
