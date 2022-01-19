package com.expert_republic.controllers;

import com.expert_republic.models.User;
import com.expert_republic.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> userRegistration(@RequestBody User user) {
        ResponseEntity<?> response = userService.registerNewUser(user);
        return response;
    }
}
