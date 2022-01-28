package com.expertrepublic.controllers;

import com.expertrepublic.dto.BookingPostDto;
import com.expertrepublic.dto.UserRegisterDto;
import com.expertrepublic.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> userRegistration(@RequestBody UserRegisterDto user) {
        ResponseEntity<?> response = userService.registerNewUser(user);
        return response;
    }

    @PostMapping("/service/{serviceId}/booking")
    public ResponseEntity<?> bookService(@RequestBody BookingPostDto bookingDto) {
        ResponseEntity<?> response = userService.bookService(bookingDto);
        return response;
    }

    @GetMapping("/all-booking")
    public ResponseEntity<?> getAllBookings() {
        ResponseEntity<?> response = userService.getAllBookings();
        return response;
    }


}
