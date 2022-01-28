package com.expertrepublic.domain;

import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name="booking")
@Data
@NoArgsConstructor
public class Booking implements Serializable{

    /*@EmbeddedId
    private BookingIDs id;*/
    /*@Id
    @Column(name="user_id")
    private Long userId;

    @Id
    @Column(name="service_id")
    private Long serviceId;*/

    /*@ManyToOne( cascade = CascadeType.ALL)
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("serviceId")
    @JoinColumn(name = "service_id")
    private ExpertAd expertAd;*/


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "service_id", referencedColumnName = "id")
    private ExpertAd expertAd;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(name="date")
    private LocalDate date;

    @Column(name="startTime")
    private LocalTime startTime;

    @Column(name="endTime")
    private LocalTime endTime;
}
