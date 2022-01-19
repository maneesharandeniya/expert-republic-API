package com.expert_republic.services;

import com.expert_republic.models.Expert;
import com.expert_republic.models.User;
import com.expert_republic.repos.ExpertRepo;
import com.expert_republic.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ExpertService {

    @Autowired
    private ExpertRepo expertRepo;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public ResponseEntity<?> registerNewExpert(Expert expert) {
        try {
            expert.setPassword(passwordEncoder.encode(expert.getPassword()));
            expertRepo.save(expert);
            return new ResponseEntity<>("Expert added successfully.", HttpStatus.OK);

        }catch (Exception e){
            System.out.println(e);
            return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}