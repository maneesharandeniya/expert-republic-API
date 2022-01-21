package com.expertrepublic.domain;

import com.expertrepublic.models.BookingIDs;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name="booking")
@Getter
@Setter
@IdClass(BookingIDs.class)
public class Booking {

    /*@EmbeddedId
    private BookingIDs id;*/
    @Id
    @Column(name="user_id")
    private Long userId;

    @Id
    @Column(name="service_id")
    private Long serviceId;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @MapsId("serviceId")
    @JoinColumn(name = "service_id")
    private ExpertAd service;

    @Column(name="date")
    @NotNull(message = "Date cannot be null")
    @NotBlank(message = "Date must not be blank")
    private LocalDate date;

    @Column(name="startTime")
    @NotNull(message = "Start time cannot be null")
    @NotBlank(message = "Start time must not be blank")
    private LocalTime startTime;

    @Column(name="endTime")
    @NotNull(message = "End time cannot be null")
    @NotBlank(message = "End time must not be blank")
    private LocalTime endTime;
}
