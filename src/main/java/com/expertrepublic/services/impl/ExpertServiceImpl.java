package com.expertrepublic.services.impl;

import com.expertrepublic.controllers.LoginController;
import com.expertrepublic.domain.Expert;
import com.expertrepublic.domain.ExpertAd;
import com.expertrepublic.repos.ExpertAdRepo;
import com.expertrepublic.repos.ExpertRepo;
import com.expertrepublic.services.CustomUserDetailsService;
import com.expertrepublic.services.ExpertService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Component
public class ExpertServiceImpl implements ExpertService {

    private final ExpertRepo expertRepo;

    private final ExpertAdRepo expertAdRepo;

    private final BCryptPasswordEncoder passwordEncoder;

    private final CustomUserDetailsService customUserDetailsService;


    public ResponseEntity<?> registerNewExpert(Expert expert) {
        try {
            final UserDetails userDetails = customUserDetailsService.loadUserByUsername(expert.getEmail());
            return new ResponseEntity<>("Email already in use.Try with a new one.", HttpStatus.BAD_REQUEST);
        }catch (UsernameNotFoundException e){
            expert.setPassword(passwordEncoder.encode(expert.getPassword()));
            expertRepo.save(expert);
            return new ResponseEntity<>("Expert added successfully.", HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e);
            return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> addNewService(ExpertAd service) {

        try {
            String userEmail = LoginController.getUserFromSession();
            Expert expert = expertRepo.findByEmail(userEmail);
            expert.getServicesAd().add(service);
            expertRepo.save(expert);
            return new ResponseEntity<>("Service added successfully", HttpStatus.CREATED);
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
}
