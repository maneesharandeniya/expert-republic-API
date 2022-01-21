package com.expertrepublic.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="service")
@Getter
@Setter
public class ExpertAd {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="title")
    @NotNull(message = "Title cannot be null")
    @NotBlank(message = "Title may not be blank")
    private String title;

    @Column(name="description")
    @NotNull(message = "Description cannot be null")
    @NotBlank(message = "Description may not be blank")
    private String description;

    @Column(name="cost")
    @NotNull(message = "Cost cannot be null")
    @Min(value = 1,message = "Minimum value of cost should be 1$")
    private float cost;

    /*@ManyToOne
    @JoinColumn(name="id")
    private Expert expert;*/
    /*@OneToMany(mappedBy = "expert_ad")
    private Set<ExpertAd> publishers = new HashSet<ExpertAd>();*/

    @OneToMany(mappedBy = "service")
    private Set<@Valid Booking> bookings = new HashSet<Booking>();

}
