package com.expert_republic.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="service")
@Getter
@Setter
public class ExpertAd {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @Column(name="cost")
    private float cost;

    @Column(name="expertId")
    private int expertId;

}
