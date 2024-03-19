package org.example;

import org.example.model.Car;
import org.example.model.Motorcycle;
import org.example.model.Vehicle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class VehicleRepository implements IVehicleRepository {

    List<Vehicle> vehicleList;
    @Override
    public void rentCar(String licencePlate) {
        if (vehicleList.isEmpty()){
            getVehicles("cars.csv");
        }
        boolean inRepository = false;
        for (Vehicle vehicle : vehicleList) {
            if (vehicle.getLicencePlate().equals(licencePlate)){
                inRepository = true;
                if (!vehicle.rented()) {
                    vehicle.setRented(true);
                    System.out.println("Wypożyczono pojazd o rejestracji: " + licencePlate);
                } else {
                    System.out.println("Pojazd jest już wypożyczony");
                }
            }
        }
        if (!inRepository){
            System.out.println("Nie znaleziono pojazdu o podanej tablicy rejestracyjnej");
        }
//        save("cars.csv");
    }

    @Override
    public void returnCar(String licencePlate) {
        if (vehicleList.isEmpty()){
            getVehicles("cars.csv");
        }
        boolean inRepository = false;
        for (Vehicle vehicle : vehicleList) {
            if (vehicle.getLicencePlate().equals(licencePlate)){
                inRepository = true;
                if (!vehicle.rented()) {
                    System.out.println("Pojazd nie był wypożyczony, nie możesz go zwrócić");
                } else {
                    vehicle.setRented(false);
                    System.out.println("Zwrócono pojazd o rejestracji: " + licencePlate);
                }
            }
        }
        if (!inRepository){
            System.out.println("Nie znaleziono pojazdu o podanej tablicy rejestracyjnej");
        }
//        save("cars.csv");
    }
    @Override
    public void getVehicles(String filepath) {
        File CSVFile = new File(filepath);
        try (Scanner scanner = new Scanner(CSVFile)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(";");
                if (data[0].equals("Car")) {
                    String brand = data[1];
                    String model = data[2];
                    int year = Integer.parseInt(data[3]);
                    double price = Double.parseDouble(data[4]);
                    String licencePlate = data[5];
                    boolean rented = Boolean.parseBoolean(data[6]);
                    Car car = new Car(model, brand, year, price, licencePlate, rented);
                    vehicleList.add(car);
                }
                if (data[0].equals("Motorcycle")) {
                    String brand = data[1];
                    String model = data[2];
                    int year = Integer.parseInt(data[3]);
                    double price = Double.parseDouble(data[4]);
                    String licencePlate = data[5];
                    boolean rented = Boolean.parseBoolean(data[6]);
                    String category = data[7];
                    Motorcycle motorcycle = new Motorcycle(model, brand, year, price, licencePlate, rented, category);
                    vehicleList.add(motorcycle);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(String filePath) {
        try {
            FileWriter writer = new FileWriter(filePath, false);
            for (Vehicle vehicle : vehicleList) {
                String data = vehicle.toCSV() + "\n";
                writer.write(data);
            }
            System.out.println("Zapisano pojazdy");
            writer.close();
        } catch (IOException e) {
            System.err.println("Błąd podczas zapisu do pliku CSV: " + e.getMessage());
        }

    }
}
