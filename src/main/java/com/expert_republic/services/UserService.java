package com.expert_republic.services;

import com.expert_republic.models.User;
import com.expert_republic.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    public ResponseEntity<?> registerNewUser(User user) {
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepo.save(user);
            return new ResponseEntity<>("User added successfully.", HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
