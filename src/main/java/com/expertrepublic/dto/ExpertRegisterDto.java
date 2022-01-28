package com.expertrepublic.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ExpertRegisterDto {

    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Name may not be blank")
    private String name;

    @NotNull(message="email cannot be null")
    @NotBlank(message = "email may not be blank")
    @Email(message = "Not a valid email address")
    private String email;

    @NotNull(message = "password cannot be null")
    @NotBlank(message = "Password must not be blank")
    private String password;

    private String description;

    private String country;

    private String languages;
}
