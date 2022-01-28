package com.expertrepublic.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="expert")
@Data
@NoArgsConstructor
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

    @OneToMany(mappedBy = "expert")
    List<@Valid ExpertAd> servicesAd = new ArrayList<ExpertAd>();

}
