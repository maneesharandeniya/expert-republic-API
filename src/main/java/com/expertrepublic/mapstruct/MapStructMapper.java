package com.expertrepublic.mapstruct;


import com.expertrepublic.domain.Booking;
import com.expertrepublic.domain.Expert;
import com.expertrepublic.domain.ExpertAd;
import com.expertrepublic.domain.User;
import com.expertrepublic.dto.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapStructMapper {

    List<ExpertAdExpertDto> expertAdToExpertAdExpertDto(List<ExpertAd> expertAd);

    ExpertExpertAdDto expertToExpertExpertAdDto(Expert expert);

    ExpertDto expertToExpertDto(Expert expert);

    ExpertAdCommonDto expertAdToExpertAdCommonDto(ExpertAd expertAd);

    ExpertAdDto expertToExpertAdDto(ExpertAd expertAd);

    UserBookingDto userToUserBooking(User user);

    List<BookingUserDto> bookingToBookingUser(List<Booking> booking);

    UserDto userToUserDto(User user);

    Expert expertRegisterDtoToExpert(ExpertRegisterDto expert);

    User userRegisterDtoToUser(UserRegisterDto userRegister);

    ExpertAd expertAdPostDtoToExpertAd(ExpertAdPostDto expertAdPostDto);

    Booking bookingPostDtoToBooking(BookingPostDto bookingPostDto);
}
