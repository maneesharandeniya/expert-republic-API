package com.expertrepublic.models;

import com.expertrepublic.domain.Expert;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ExpertDetailsPrincipal implements UserDetails {

    private Expert expert;

    public ExpertDetailsPrincipal(Expert expert){
        this.expert = expert;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> auth = new ArrayList<>();
        auth.add(new SimpleGrantedAuthority("ROLE_EXPERT"));
        return auth;
    }

    @Override
    public String getPassword() {
        return expert.getPassword();
    }

    @Override
    public String getUsername() {
        return expert.getEmail();
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
