package com.expertrepublic.services;

import com.expertrepublic.domain.User;
import com.expertrepublic.dto.BookingDto;
import org.springframework.http.ResponseEntity;


public interface UserService {

    public ResponseEntity<?> registerNewUser(User user);

    public ResponseEntity<?> bookService(BookingDto bookingDto);

    public ResponseEntity<?> getAllBookings();
}
