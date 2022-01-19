package com.expert_republic.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {

    //@NotBlank(message = "User Email is mandatory")
    private String userEmail;
   // @NotBlank(message = "Password is mandatory")
    private String password;

}
