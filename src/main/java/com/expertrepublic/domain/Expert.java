package com.expertrepublic.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="expert")
@Getter
@Setter
public class Expert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Name may not be blank")
    private String name;

    @Column(name="email")
    @NotNull(message="email cannot be null")
    @NotBlank(message = "email may not be blank")
    @Email(message = "Not a valid email address")
    private String email;

    @Column(name="password")
    @NotNull(message = "password cannot be null")
    @NotBlank(message = "Password must not be blank")
    private String password;

    @Column(name="description")
    private String description;

    @Column(name="country")
    private String country;

    @Column(name="languages")
    private String languages;

    @OneToMany(mappedBy = "expert")
    List<@Valid ExpertAd> servicesAd = new ArrayList<ExpertAd>();

}
