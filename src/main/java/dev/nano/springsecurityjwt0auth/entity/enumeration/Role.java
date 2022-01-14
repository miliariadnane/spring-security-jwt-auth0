package dev.nano.springsecurityjwt0auth.entity.enumeration;

import static dev.nano.springsecurityjwt0auth.entity.Authority.ADMIN_AUTHORITIES;
import static dev.nano.springsecurityjwt0auth.entity.Authority.USER_AUTHORITIES;

public enum Role {
    ROLE_USER(USER_AUTHORITIES),
    ROLE_ADMIN(ADMIN_AUTHORITIES);

    private String[] authorities;

    Role(String... authorities) {
        this.authorities = authorities;
    }

    public String[] getAuthorities() {
        return authorities;
    }
}
