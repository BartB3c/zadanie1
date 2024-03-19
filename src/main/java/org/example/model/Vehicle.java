package org.example.model;


import java.util.List;

public abstract class Vehicle {
    private String brand;
    private String model;

    public Vehicle(String brand, String model, int year, double price, String licencePlate, boolean rented) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
        this.licencePlate = licencePlate;
        this.rented = rented;
    }

    private int year;
    private double price;

    private String licencePlate;

    private boolean rented;

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public boolean rented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }

    public abstract String toCSV();

    @Override
    public String toString() {
        return "Vehicle{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", licencePlate='" + licencePlate + '\'' +
                ", rented=" + rented +
                '}';
    }
}
