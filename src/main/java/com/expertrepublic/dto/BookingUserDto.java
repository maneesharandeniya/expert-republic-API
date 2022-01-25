package com.expertrepublic.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class BookingUserDto {
    private Long bookingId;

    private ExpertAdCommonDto expertAd;

    private LocalDate date;

    private LocalTime startTime;

    private LocalTime endTime;
}
