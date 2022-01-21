package com.expertrepublic.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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
    private String title;

    @Column(name="description")
    private String description;

    @Column(name="cost")
    private float cost;

    /*@ManyToOne
    @JoinColumn(name="id")
    private Expert expert;*/
    /*@OneToMany(mappedBy = "expert_ad")
    private Set<ExpertAd> publishers = new HashSet<ExpertAd>();*/

}
