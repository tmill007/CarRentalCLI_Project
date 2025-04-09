package com.carrental;

import com.carrental.DAO.*;
import com.carrental.Models.CarStatus;
import com.carrental.Models.Menu;
import com.carrental.Services.BookingService;
import com.carrental.Services.CarService;
import com.carrental.Services.MenuService;
import com.carrental.Services.UserService;
import com.github.javafaker.Faker;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        UserDAO userDAO = new IUserFakerDataAccessService();
        //UserDAO userDAO = new IUserCSVDataAccessObject();
        //UserDAO userDAO = new IUserArrayDataAccessObject();
        CarDAO carDAO = new CarDAO();
        BookingDAO bookingDAO = new BookingDAO();
        CarService carService = new CarService(carDAO);
        UserService userService = new UserService(userDAO);
        BookingService bookingService = new BookingService(userService, carService, bookingDAO);

        MenuService menuService = new MenuService(userService, carService, bookingService);

        menuService.start();
        }

    }

