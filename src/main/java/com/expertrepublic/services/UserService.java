package com.expertrepublic.services;

import com.expertrepublic.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    public ResponseEntity<?> registerNewUser(User user);
}
