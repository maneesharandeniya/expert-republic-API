package com.expert_republic.models;

import java.io.Serializable;

public class BookingIDs implements Serializable {

    private Long userId;
    private Long serviceId;

    public BookingIDs() {
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
