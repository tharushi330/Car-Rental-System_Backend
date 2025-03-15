package edu.icet.ecom.service;


import edu.icet.ecom.dto.Booking;

import java.util.List;

public interface BookingService {
    Booking createBooking(Booking booking);
    Booking getBookingById(Long id);
    List<Booking> getAllBookings();
    Booking updateBooking(Long id, Booking booking);
    void deleteBooking(Long id);
}
