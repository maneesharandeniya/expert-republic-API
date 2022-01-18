package com.expert_republic.models;

import java.io.Serializable;

public class BookingIDs implements Serializable {

    private int userId;
    private int serviceId;

    public BookingIDs(int userId, int serviceId) {
        this.userId = userId;
        this.serviceId = serviceId;
    }

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
