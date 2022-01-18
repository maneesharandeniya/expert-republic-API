package com.expert_republic.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="service")
@Getter
@Setter
public class ExpertService {

    @Id
    @Column(name="id")
    private int id;

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @Column(name="cost")
    private float cost;

    @Column(name="expertId")
    private int expertId;

}
