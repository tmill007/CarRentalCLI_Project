package com.carrental.Models;

import java.util.Objects;

public class Car {
    private String regNumber;
    private double rentalPrice;
    private Brand brand;
    private FuelType fuelType;
    private CarStatus carStatus;

    public Car(String regNumber, double rentalPrice, Brand brand, FuelType fuelType, CarStatus carStatus) {
        this.regNumber = regNumber;
        this.rentalPrice = rentalPrice;
        this.brand = brand;
        this.fuelType = fuelType;
        this.carStatus = carStatus;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public double getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice(double rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public CarStatus getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(CarStatus carStatus) {
        this.carStatus = carStatus;
    }

    @Override
    public String toString() {
        return "Car{" +
                "regNumber='" + regNumber + '\'' +
                ", rentalPrice=" + rentalPrice +
                ", brand=" + brand +
                ", fuelType=" + fuelType +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Double.compare(rentalPrice, car.rentalPrice) == 0 && Objects.equals(regNumber, car.regNumber) && brand == car.brand && fuelType == car.fuelType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(regNumber, rentalPrice, brand, fuelType);
    }
}
