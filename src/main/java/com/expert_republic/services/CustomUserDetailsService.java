package com.expert_republic.services;

import com.expert_republic.models.Expert;
import com.expert_republic.models.ExpertDetailsPrincipal;
import com.expert_republic.models.User;
import com.expert_republic.models.UserDetailsPrincipal;
import com.expert_republic.repos.ExpertRepo;
import com.expert_republic.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("custom")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private ExpertRepo expertRepo;

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {

        Optional<Expert> expert = expertRepo.findById(Long.parseLong(id));
        Optional<User> user = userRepo.findById(Long.parseLong(id));

        if(!expert.isPresent()) {
            return new ExpertDetailsPrincipal(expert);
        }else if(!user.isPresent()) {
            return new UserDetailsPrincipal(user);
        }
        throw new UsernameNotFoundException("User not found with id: " + id);
    }
}
