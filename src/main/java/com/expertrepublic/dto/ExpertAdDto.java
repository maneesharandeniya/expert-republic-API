package com.expertrepublic.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ExpertAdDto {

    private Long id;

    private String title;

    private String description;

    private float cost;

    private List<BookingExpertAdDto> bookings = new ArrayList<BookingExpertAdDto>();

    private ExpertExpertAdDto expert;
}
