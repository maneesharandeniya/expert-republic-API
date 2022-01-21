package com.expertrepublic.services;

import com.expertrepublic.domain.Expert;
import com.expertrepublic.models.ExpertDetailsPrincipal;
import com.expertrepublic.domain.User;
import com.expertrepublic.models.UserDetailsPrincipal;
import com.expertrepublic.repos.ExpertRepo;
import com.expertrepublic.repos.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("custom")
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final ExpertRepo expertRepo;

    private final UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Expert expert = expertRepo.findByEmail(email);
        User user = userRepo.findByEmail(email);

        if(expert != null) {
            return new ExpertDetailsPrincipal(expert);
        }else if(user != null) {
            return new UserDetailsPrincipal(user);
        }
        throw new UsernameNotFoundException("User not found with id: " + email);
    }
}
