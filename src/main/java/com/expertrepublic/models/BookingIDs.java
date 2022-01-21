package com.expertrepublic.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class BookingIDs implements Serializable {
    // @Column(name="user_id")
    private Long userId;
    // @Column(name="service_id")
    private Long serviceId;

    public BookingIDs() {
    }

    public BookingIDs(Long userId, Long serviceId) {
        this.userId = userId;
        this.serviceId = serviceId;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
