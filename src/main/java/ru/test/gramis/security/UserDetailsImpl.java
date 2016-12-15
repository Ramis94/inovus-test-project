package ru.test.gramis.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.test.gramis.entity.Role;
import ru.test.gramis.entity.Users;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by GRamis on 12.12.2016.
 * Содержит в себе данные пользователя
 */
public class UserDetailsImpl implements UserDetails {

    private final Users userInfo;

    public UserDetailsImpl(Users userInfo) {
        this.userInfo = userInfo;
    }

    public Users getUserInfo() {
        return userInfo;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        ArrayList<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (Role role: userInfo.getRole()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.toString()));
        }
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return userInfo.getPassword();
    }

    @Override
    public String getUsername() {
        return userInfo.getName();
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
