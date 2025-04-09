package com.carrental.DAO;

import com.carrental.Models.*;
import com.carrental.Services.BookingService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarDAO {
    private static List<Car> cars;

    static {
        cars = new ArrayList<>(Arrays.asList(
                new Car("123", 75.00, Brand.HONDA, FuelType.GAS, CarStatus.AVAILABLE),
                new Car("456", 150.00, Brand.BMW, FuelType.ELECTRIC, CarStatus.AVAILABLE),
                new Car("789", 175.00, Brand.TESLA, FuelType.ELECTRIC, CarStatus.AVAILABLE),
                new Car("987", 69.00, Brand.TOYOTA, FuelType.GAS, CarStatus.AVAILABLE),
                new Car("654", 95.00, Brand.MERCEDES, FuelType.GAS, CarStatus.AVAILABLE)
        ));
    }

    public CarDAO() {
    }

    public List<Car> getAvailableCars() {
        return cars.stream()
                    .filter(car -> car.getCarStatus() == CarStatus.AVAILABLE)
                    .collect(Collectors.toList());
    }

    public List <Car> getAvailableCars(FuelType fuelType) {
        return cars.stream()
                    .filter(car -> car.getFuelType() == fuelType && car.getCarStatus() == CarStatus.AVAILABLE)
                    .collect(Collectors.toList());
    }

    public boolean isValidRegNumber(String regNumber) {

        return getAvailableCars().stream().anyMatch(car -> car.getRegNumber().equals(regNumber));
//
    }

    public Car getCarByRegNumber(String regNumber) {

        for(Car car : cars){
            if(car.getRegNumber().equals(regNumber)){
                return car;
            }
        } return null;
    }
}
