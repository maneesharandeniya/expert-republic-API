package com.expert_republic.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name="booking")
@Getter
@Setter
@IdClass(BookingIDs.class)
public class Booking {

    @Id
    @Column(name="userId")
    private Long userId;

    @Id
    @Column(name="serviceId")
    private Long serviceId;

    @Column(name="date")
    private LocalDate date;

    @Column(name="startTime")
    private LocalTime startTime;

    @Column(name="endTime")
    private LocalTime endTime;
}
