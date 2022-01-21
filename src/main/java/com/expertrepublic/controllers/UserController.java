package com.expertrepublic.controllers;

import com.expertrepublic.domain.User;
import com.expertrepublic.dto.BookingDto;
import com.expertrepublic.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> userRegistration(@RequestBody User user) {
        ResponseEntity<?> response = userService.registerNewUser(user);
        return response;
    }

    @PostMapping("/service/booking")
    public ResponseEntity<?> bookService(@RequestBody BookingDto bookingDto) {
        ResponseEntity<?> response = userService.bookService(bookingDto);
        return response;
    }

}
