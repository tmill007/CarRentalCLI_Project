package com.carrental.Services;

import com.carrental.DAO.CarDAO;
import com.carrental.Models.Car;
import com.carrental.Models.FuelType;

public class CarService {
    private CarDAO carDAO;

    public CarService(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    public void displayAvailableCars(){
        if(carDAO.getAvailableCars().isEmpty()){
            System.out.println();
            System.out.println("*** No Cars Available ***".toUpperCase());
        } else{
            System.out.println();
            System.out.println("Available Cars: ".toUpperCase());
            carDAO.getAvailableCars().forEach(System.out::println);
        }
    }

    public void displayAvailableCars(FuelType fuelType) {
        if(carDAO.getAvailableCars(fuelType).isEmpty()){
            System.out.println();
            System.out.printf("*** No %s Cars Available ***".toUpperCase(), fuelType);
        } else{
            System.out.println();
            System.out.printf("Available %s Cars: \n".toUpperCase(), fuelType);
            carDAO.getAvailableCars(fuelType).forEach(System.out::println);
        }
    }

    public boolean isValidRegNumber(String regNumber) {
        return carDAO.isValidRegNumber(regNumber);
    }

    public Car getCarByRegNumber(String regNumber) {
        if(isValidRegNumber(regNumber)){
            return carDAO.getCarByRegNumber(regNumber);
        } return null;
    }


}
