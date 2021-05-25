package play.laika.auth2.config.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import play.laika.auth2.web.io.UserDto;

import java.util.Collection;
import java.util.Collections;

public class CustomUserDetails implements UserDetails {

    private final String login;
    private final Collection<? extends GrantedAuthority> grantedAuthorities;

    private CustomUserDetails(String login, Collection<? extends GrantedAuthority> grantedAuthorities) {
        this.login = login;
        this.grantedAuthorities = grantedAuthorities;
    }

    public static CustomUserDetails fromUserDto(UserDto user) {
        return new CustomUserDetails(
                user.getDeviceId(),
                Collections.singletonList(new SimpleGrantedAuthority(user.getRole())));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
