package dev.nano.springsecurityjwt0auth.security.constant;

public class SecurityConstant {

    public static final long EXPIRATION_TIME = 604_800_000; // 7 days (one week) expressed in milliseconds
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String JWT_TOKEN_HEADER = "Jwt-Token"; // custom token header
    public static final String TOKEN_CANNOT_BE_VERIFIED = "Token cannot be verified";
    public static final String NANO_LLC = "Nano dev, LLC";
    public static final String NANO_SPRINGSECURITY_DEMO = "Demo Spring Security 0auth - Jwt";
    public static final String AUTHORITIES = "authorities"; // authorities of user
    public static final String FORBIDDEN_MESSAGE = "You need to log in to access this page";
    public static final String ACCESS_DENIED_MESSAGE = "You do not have permission to access this page";
    public static final String OPTIONS_HTTP_STATUS = "OPTIONS";
    public static final String TOKEN_SECRET = "[a-zA-Z0-9._]^+f7re87456rcdf987cr89df745fddsds45ds89";
    public static final String[] PUBLIC_URLS = {
            "/api/v1/users/login",
            "/api/v1/users/register"
    };
}
