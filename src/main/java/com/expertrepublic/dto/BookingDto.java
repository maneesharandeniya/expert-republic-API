package com.expertrepublic.dto;


import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class BookingDto {

    private Long serviceId;

    private LocalDate date;

    private LocalTime startTime;

    private LocalTime endTime;
}
