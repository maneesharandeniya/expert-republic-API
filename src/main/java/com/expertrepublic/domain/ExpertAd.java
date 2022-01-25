package com.expertrepublic.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @OneToMany(mappedBy = "expertAd")
    private List<@Valid Booking> bookings = new ArrayList<Booking>();

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "expert_id", referencedColumnName = "id")
    private Expert expert;

}
