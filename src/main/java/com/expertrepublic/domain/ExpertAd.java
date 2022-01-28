package com.expertrepublic.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.Valid;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="service")
@Data
@NoArgsConstructor
public class ExpertAd implements Serializable {

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

    @OneToMany(mappedBy = "expertAd")
    private List<@Valid Booking> bookings = new ArrayList<Booking>();

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "expert_id", referencedColumnName = "id")
    private Expert expert;

}
