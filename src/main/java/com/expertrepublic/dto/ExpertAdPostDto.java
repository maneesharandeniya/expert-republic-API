package com.expertrepublic.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ExpertAdPostDto {

    @NotNull(message = "Title cannot be null")
    @NotBlank(message = "Title may not be blank")
    private String title;

    @NotNull(message = "Description cannot be null")
    @NotBlank(message = "Description may not be blank")
    private String description;

    @NotNull(message = "Cost cannot be null")
    @Min(value = 1,message = "Minimum value of cost should be 1$")
    private float cost;
}
