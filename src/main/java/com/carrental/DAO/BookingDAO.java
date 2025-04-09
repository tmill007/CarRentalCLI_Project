package com.carrental.DAO;

import com.carrental.Models.Booking;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BookingDAO {
    private List<Booking> bookings;

    public BookingDAO() {
        this.bookings = new ArrayList<>();
    }

    public Booking createBooking(Booking booking) {
        bookings.add(booking);
        return booking;
    }

    public List<Booking> getBookings() {
        return bookings;

    }

    public List<Booking> getBookingsByUser(String userId) {
        return bookings.stream()
                        .filter(booking -> booking.getUser().getUserId().equals(userId))
                        .collect(Collectors.toList());
    }
}
