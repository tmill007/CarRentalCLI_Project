package com.carrental.Services;


import com.carrental.Models.FuelType;

import java.util.Scanner;
import java.util.UUID;

public class MenuService {
    private UserService userService;
    private CarService carService;
    private BookingService bookingService;

    public MenuService(UserService userService, CarService carService, BookingService bookingService) {
        this.userService = userService;
        this.carService = carService;
        this.bookingService = bookingService;
    }

    public void start(){
       Scanner scanner = new Scanner(System.in);


        System.out.println();
        System.out.print("************* \uD83D\uDE98 Booking System \uD83D\uDE98 *************".toUpperCase());
        displayMenu();
        boolean isFinished = false;

        while (!isFinished) {
            String userInput = scanner.nextLine();

        switch (userInput){
            case "1":
                handleBookCar(scanner);
                break;
            case "2":
                handleViewCarBookingsByUserId(scanner);
                break;
            case "3":
                bookingService.getAllBooking();
                break;
            case "4":
                carService.displayAvailableCars();
                break;
            case "5":
                carService.displayAvailableCars(FuelType.ELECTRIC);
                break;
            case "6":
                userService.displayAvailableUsers();
                break;
            case "7":
                System.out.println();
                System.out.println("======= Exiting Booking System =======".toUpperCase());
                isFinished = true;
                break;

        }
           if(!isFinished){
               System.out.println();
               displayMenu();
           }

    }
    }



    public void displayMenu(){
        System.out.println();
        System.out.println("\u27A1\uFE0F please choose from the below options:".toUpperCase());
        System.out.printf("1\uFE0F\u20E3 %s", "Book A Car");
        System.out.println();
        System.out.printf("2\uFE0F\u20E3 %s", "View All User Booked Cars");
        System.out.println();
        System.out.printf("3\uFE0F\u20E3 %s", "View All Bookings");
        System.out.println();
        System.out.printf("4\uFE0F\u20E3 %s", "View Available Cars");
        System.out.println();
        System.out.printf("5\uFE0F\u20E3 %s", "View Available ELECTRIC Cars");
        System.out.println();
        System.out.printf("6\uFE0F\u20E3 %s", "View All Users");
        System.out.println();
        System.out.printf("7\uFE0F\u20E3 %s", "Exit");
        System.out.println();

    }

    public void handleBookCar(Scanner scanner){
        String userID;
        boolean isValid = false;
        do{
            System.out.println();
            System.out.println("\u27A1\uFE0F Please provide a USER_ID for this booking:".toUpperCase());
            userService.displayAvailableUsers();
            userID = scanner.nextLine();
            isValid = userService.isValidUserId(userID);
            if(!isValid){
                System.out.println();
                System.out.printf("⛔ userID: %s is Invalid \n".toUpperCase(), userID);
            }
        } while (!isValid);
        //ToDo:  do do while loop to display and validate car selection

        String regNumber;
        isValid = false;
        do{
            System.out.println();
            System.out.println("\u27A1\uFE0F Provide a Reg_Number for vehicle to book:".toUpperCase());
            carService.displayAvailableCars(); //ToDo: Modify so it only returns cars not yet booked
            regNumber = scanner.nextLine();
            isValid = carService.isValidRegNumber(regNumber);
            if(!isValid){
                System.out.println();
                System.out.printf("⛔ regNumber: %s is Invalid \n".toUpperCase(), regNumber);
            }
        } while (!isValid);

       //ToDo:  Create booking for vehicle
        bookingService.createBooking(userID, regNumber);
}

    private void handleViewCarBookingsByUserId(Scanner scanner) {
        String userID;
        boolean isValid = false;
        do{
            System.out.println();
            System.out.println("\u27A1\uFE0F Provide a UserID: ".toUpperCase());
            userService.displayAvailableUsers();
            userID = scanner.nextLine();
            isValid = userService.isValidUserId(userID);
            if(!isValid){
                System.out.println();
                System.out.printf("⛔ Invalid UserId: %s \n".toUpperCase(), userID);
            }
        } while (!isValid);


        bookingService.displayBookingByUser(userID);


    }

}
