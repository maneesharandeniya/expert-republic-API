package com.expertrepublic.domain;

import com.expertrepublic.models.BookingIDs;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name="booking")
@Getter
@Setter

public class Booking {

   /* @Id
    private Long userId;

    @Id
    private Long serviceId;*/
    @EmbeddedId
    private BookingIDs id = new BookingIDs();

    @ManyToOne
    @MapsId("userId")
    private User user;

    @ManyToOne
    @MapsId("serviceId")
    private ExpertAd service;

    @Column(name="date")
    private LocalDate date;

    @Column(name="startTime")
    private LocalTime startTime;

    @Column(name="endTime")
    private LocalTime endTime;
}
