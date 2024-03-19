package org.example;


public class Car extends Vehicle {


    public Car(String brand, String model, int year, double price, String licencePlate, boolean rented) {
        super(brand, model, year, price, licencePlate, rented);
    }


    @Override
    public String toString() {
        return "Samochod{" +
                "marka='" + super.getBrand() + '\'' +
                ", model: '" + super.getModel() + '\'' +
                ", rok: " + super.getYear() + '\'' +
                ", cena: " + super.getPrice() + '\'' +
                ", rejestracja: " + super.getLicencePlate() + '\'' +
                ", wypożyczony: " + super.rented() + '\'';

    }

    @Override
    public String toCSV() {
        return "Car;" + getBrand() + ";" + getModel() + ";" + getYear() + ";" +  getPrice() + ";" + getLicencePlate() + ";" + rented();

    }
}
