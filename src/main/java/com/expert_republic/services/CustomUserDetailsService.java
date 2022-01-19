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
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Expert expert = expertRepo.findByEmail(email);
        User user = userRepo.findByEmail(email);

      //  System.out.println(expert.isPresent());
      //  System.out.println(user.isPresent());

        if(expert != null) {
            return new ExpertDetailsPrincipal(expert);
        }else if(user != null) {
            return new UserDetailsPrincipal(user);
        }
        throw new UsernameNotFoundException("User not found with id: " + email);
    }
}
