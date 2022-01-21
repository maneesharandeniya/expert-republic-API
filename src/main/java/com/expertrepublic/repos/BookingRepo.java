package com.expertrepublic.repos;

import com.expertrepublic.domain.Booking;
import com.expertrepublic.models.BookingIDs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepo extends JpaRepository<Booking, BookingIDs> {


}
