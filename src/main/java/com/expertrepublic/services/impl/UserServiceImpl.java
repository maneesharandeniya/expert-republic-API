package com.expertrepublic.services.impl;

import com.expertrepublic.controllers.LoginController;
import com.expertrepublic.domain.Booking;
import com.expertrepublic.domain.Expert;
import com.expertrepublic.domain.ExpertAd;
import com.expertrepublic.domain.User;
import com.expertrepublic.dto.BookingDto;
import com.expertrepublic.dto.BookingUserDto;
import com.expertrepublic.dto.ExpertDto;
import com.expertrepublic.dto.UserDto;
import com.expertrepublic.mapstruct.MapStructMapper;
import com.expertrepublic.models.BookingIDs;
import com.expertrepublic.repos.BookingRepo;
import com.expertrepublic.repos.ExpertAdRepo;
import com.expertrepublic.repos.UserRepo;
import com.expertrepublic.services.CustomUserDetailsService;
import com.expertrepublic.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    private final ExpertAdRepo expertAdRepo;

    private final BookingRepo bookingRepo;

    private final BCryptPasswordEncoder passwordEncoder;

    private final CustomUserDetailsService customUserDetailsService;

    @Autowired
    MapStructMapper mapStructMapper;

    public ResponseEntity<?> registerNewUser(User user) {
        try {
            final UserDetails userDetails = customUserDetailsService.loadUserByUsername(user.getEmail());
            return new ResponseEntity<>("Email already in use. Try with a new one.", HttpStatus.BAD_REQUEST);
        }catch (UsernameNotFoundException e){
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepo.save(user);
            return new ResponseEntity<>("User added successfully.", HttpStatus.CREATED);
        }catch (Exception e){
            System.out.println(e);
            return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> bookService(BookingDto bookingDto){

        String userEmail = LoginController.getUserFromSession();

        User user = userRepo.findByEmail(userEmail);
        Optional<ExpertAd> expertAd = expertAdRepo.findById(bookingDto.getServiceId());

        Booking booking = new Booking();
      //  booking.setUserId(user.getId());
       // booking.setServiceId(bookingDto.getServiceId());
       // booking.setDate(bookingDto.getDate());
       // booking.setStartTime(bookingDto.getStartTime());
       // booking.setStartTime(bookingDto.getEndTime());

        booking.setExpertAd(expertAd.get());
        booking.setUser(user);
       // booking.setService(expertAd.get());
      //  user.getBookings().add(booking);

       // expertAd.get().getBookings().add(booking);

      // userRepo.save(user);
      //  expertAdRepo.save(expertAd.get());
       bookingRepo.save(booking);

        return new ResponseEntity<>("Booking added successfully.", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getAllBookings() {

        String userEmail = LoginController.getUserFromSession();
        if(userEmail == null){
            return new ResponseEntity<>("Email address not found.", HttpStatus.BAD_REQUEST);
        }
        User user = userRepo.findByEmail(userEmail);
        //UserDto userDto = mapStructMapper.userToUserDto(user);

        List<BookingUserDto> bookingUserDtoList = mapStructMapper.bookingToBookingUser(user.getBookings());

        return new ResponseEntity<>(bookingUserDtoList, HttpStatus.OK);

    }
}
