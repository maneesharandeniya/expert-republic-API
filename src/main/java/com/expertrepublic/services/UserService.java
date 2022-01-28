package com.expertrepublic.services;

import com.expertrepublic.dto.BookingPostDto;
import com.expertrepublic.dto.UserRegisterDto;
import org.springframework.http.ResponseEntity;


public interface UserService {

    public ResponseEntity<?> registerNewUser(UserRegisterDto user);

    public ResponseEntity<?> bookService(BookingPostDto bookingDto);

    public ResponseEntity<?> getAllBookings();
}
