package com.expertrepublic.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class BookingPostDto {

    private Long serviceId;

    private LocalDate date;

    @NotNull(message = "Start time cannot be null")
    @NotBlank(message = "Start time must not be blank")
   /* @DateTimeFormat(style = "hh:mm")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="hh:mm")*/
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalTime startTime;

    /*@NotNull(message = "End time cannot be null")
    @NotBlank(message = "End time must not be blank")*/
    private LocalTime endTime;
}
