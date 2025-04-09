package com.carrental.Models;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class Booking {
    private User user;
    private Car car;
    private LocalDateTime bookingDate;
    private BookingStatus bookingStatus;
    private String bookingID;

    public Booking(User user, Car car) {
        this.user = user;
        this.car = car;
        this.bookingDate = LocalDateTime.now();
        this.bookingStatus = BookingStatus.BOOKED;
        this.bookingID = UUID.randomUUID().toString();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public String getBookingID() {
        return bookingID;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "user=" + user +
                ", car=" + car +
                ", bookingDate=" + bookingDate +
                ", bookingStatus=" + bookingStatus +
                ", bookingID='" + bookingID + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(user, booking.user) && Objects.equals(car, booking.car) && Objects.equals(bookingDate, booking.bookingDate) && bookingStatus == booking.bookingStatus && Objects.equals(bookingID, booking.bookingID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, car, bookingDate, bookingStatus, bookingID);
    }
}
