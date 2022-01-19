package com.expert_republic.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="expert")
@Getter
@Setter
public class Expert {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="password")
    private String password;

    @Column(name="description")
    private String description;

    @Column(name="country")
    private String country;

    @Column(name="languages")
    private String languages;

}
