package org.example;

import org.example.model.Car;
import org.example.model.Motorcycle;
import org.example.model.Vehicle;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String filename = "cars.csv";
        VehicleRepository vehicleRepository = new VehicleRepository();
        Car car1 = new Car("Toyota", "Corolla", 2018, 20000, "ABC123", false);
        Car car2 = new Car("Honda", "Civic", 2019, 22000, "DEF456", false);
        Motorcycle motorcycle1 = new Motorcycle("Harley-Davidson", "Sportster", 2020, 15000, "GHI789", true, "Cruiser");
        Motorcycle motorcycle2 = new Motorcycle("Kawasaki", "Ninja", 2021, 18000, "JKL012", false, "Sport");

        vehicleRepository.vehicleList = new ArrayList<>();

        vehicleRepository.vehicleList.add(car1);
        vehicleRepository.vehicleList.add(car2);
        vehicleRepository.vehicleList.add(motorcycle1);
        vehicleRepository.vehicleList.add(motorcycle2);
        vehicleRepository.save(filename);
        System.out.println("Przed wypożyczeniem: ");
        for (Vehicle v : vehicleRepository.vehicleList){
            System.out.println(v);
        }
        System.out.println("\n");
        vehicleRepository.rentCar("ABC123");
        vehicleRepository.rentCar("DEF456");
        vehicleRepository.save(filename);
        System.out.println("Po wypożyczeniu: ");
        for (Vehicle v : vehicleRepository.vehicleList){
            System.out.println(v);
        }

        System.out.println("\n");
        System.out.println("Po zwrocie:");
        vehicleRepository.returnCar("ABC123");
        for (Vehicle v : vehicleRepository.vehicleList){
            System.out.println(v);
        }



    }
}