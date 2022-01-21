package com.expertrepublic.services;

import com.expertrepublic.domain.User;
import com.expertrepublic.dto.BookingDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    public ResponseEntity<?> registerNewUser(User user);

    public ResponseEntity<?> bookService(BookingDto bookingDto);
}
