package com.expertrepublic.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class BookingExpertAdDto {

    private Long bookingId;

    private UserBookingDto user;

    private LocalDate date;

    private LocalTime startTime;

    private LocalTime endTime;
}
