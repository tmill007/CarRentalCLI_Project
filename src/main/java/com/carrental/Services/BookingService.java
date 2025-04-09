package com.carrental.Services;

import com.carrental.DAO.BookingDAO;
import com.carrental.Models.Booking;
import com.carrental.Models.Car;
import com.carrental.Models.CarStatus;
import com.carrental.Models.User;

import java.util.Arrays;
import java.util.List;

public class BookingService {
    private UserService userService;
    private CarService carService;
    private BookingDAO bookingDAO;

    public BookingService(UserService userService, CarService carService, BookingDAO bookingDAO) {
        this.carService = carService;
        this.userService = userService;
        this.bookingDAO = bookingDAO;
    }

    public void getAllBooking(){
        List<Booking> bookings = bookingDAO.getBookings();
        if( bookings.isEmpty()){
            System.out.println();
            System.out.println("No Bookings Available".toUpperCase());
        }else {
            System.out.println();
            System.out.println(" *** Bookings *** ".toUpperCase());
            bookings.forEach(booking -> {
                System.out.printf("User: %s | Car: %s | Status: %s | BookingID: %s |BookingDate: %s\n".toUpperCase(), booking.getUser().getName(), booking.getCar().getBrand(), booking.getBookingStatus(), booking.getBookingID(), booking.getBookingDate());
            });
        }
    }

    public void createBooking(String userID, String regNumber) {
        User user =  userService.getUserById(userID);
        Car car = carService.getCarByRegNumber(regNumber);
        car.setCarStatus(CarStatus.BOOKED);
        var booking = new Booking(user, car);
        bookingDAO.createBooking(booking);
       //Can put some validation here
        System.out.println();
        System.out.printf(("✅ New Booking Confirmation - Booking ID: %s").toUpperCase(), booking.getBookingID());
        System.out.println();
        System.out.printf("User: %s | Car: %s | Status: %s | BookingID: %s |BookingDate: %s\n".toUpperCase(), booking.getUser().getName(), booking.getCar().getBrand(), booking.getBookingStatus(), booking.getBookingID(), booking.getBookingDate());
    }

    public void displayBookingByUser(String userID) {
        List<Booking> userBookings = bookingDAO.getBookingsByUser(userID);
        if(!userBookings.isEmpty()){
            System.out.println();
            System.out.printf("Available Bookings for User %s : \n".toUpperCase(), userID);
            userBookings.forEach(booking -> {
                System.out.printf("User: %s | Car: %s | Status: %s | BookingID: %s |BookingDate: %s\n".toUpperCase(), booking.getUser().getName(), booking.getCar().getBrand(), booking.getBookingStatus(), booking.getBookingID(), booking.getBookingDate());
            });
        } else{
            System.out.println();
            System.out.printf("***** No Bookings Found for user %s *****\n".toUpperCase(), userID);
        }
    }
}
