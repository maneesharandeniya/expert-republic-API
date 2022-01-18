package com.expert_republic.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

public class UserDetailsPrincipal implements UserDetails {
    private Optional<User> user;

    public UserDetailsPrincipal(Optional<User> user){
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> auth = new ArrayList<>();
        auth.add(new SimpleGrantedAuthority("ROLE_EXPERT"));
        return auth;
    }

    @Override
    public String getPassword() {
        AtomicReference<String> password = null;
        user.ifPresent(e ->{
            password.set(e.getPassword());
        });
        return password.get();
    }

    @Override
    public String getUsername() {
        //return Long.toString(expert.getId());
        AtomicReference<String> id = null;
        user.ifPresent(e ->{
            id.set(Long.toString(e.getId()));
        });
        return id.get();
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
