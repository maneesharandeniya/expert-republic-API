package com.expertrepublic.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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
    private String name;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="description")
    private String description;

    @Column(name="country")
    private String country;

    @Column(name="languages")
    private String languages;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "expert_id", referencedColumnName = "id")
    List<ExpertAd> servicesAd = new ArrayList<ExpertAd>();

}
