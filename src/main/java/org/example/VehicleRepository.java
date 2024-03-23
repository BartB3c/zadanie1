package org.example;

import org.example.model.Car;
import org.example.model.Motorcycle;
import org.example.model.User;
import org.example.model.Vehicle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehicleRepository implements IVehicleRepository {

    private static final String vehicleFile = "vehicles.csv";
    UserRepository userRepository = new UserRepository();

    private List<Vehicle> vehicleList;

    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public VehicleRepository() {
        vehicleList = new ArrayList<>();
        getVehicles();
    }

    public void setVehicleList(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

    @Override
    public void rentVehicle(String licencePlate, String login) {
        User user = userRepository.getUser(login);
        boolean inRepository = false;
        for (Vehicle vehicle : vehicleList) {
            if (vehicle.getLicencePlate().equals(licencePlate)) {
                inRepository = true;
                if (!vehicle.rented()) {
                    vehicle.setRented(true);
                    user.setRentedCarPlate(licencePlate);
                    System.out.println("Użytkownik " + user.getLogin() + " wypożyczył pojazd o rejestracji: " + licencePlate);
                    userRepository.save();
                    save();
                } else {
                    System.out.println("Pojazd jest już wypożyczony");
                }
            }
        }
        if (!inRepository) {
            System.out.println("Nie znaleziono pojazdu o podanej tablicy rejestracyjnej");
        }
    }

    @Override
    public void returnVehicle(String licencePlate, String login) {
        User user = userRepository.getUser(login);
        boolean inRepository = false;
        for (Vehicle vehicle : vehicleList) {
            if (vehicle.getLicencePlate().equals(licencePlate)) {
                inRepository = true;
                if (!vehicle.rented()) {
                    System.out.println("Pojazd nie był wypożyczony, nie możesz go zwrócić");
                } else {
                    String rentedCarPlate = user.getRentedCarPlate();
                    if (rentedCarPlate == null || !rentedCarPlate.equals(licencePlate)) {
                        System.out.println("Inny użytkownik musi zwrócić ten pojazd");
                    } else {
                        vehicle.setRented(false);
                        user.setRentedCarPlate("null");
                        System.out.println("Użytkownik " + user.getLogin() + " zwrócił pojazd o rejestracji: " + vehicle.getLicencePlate());
                        save();
                    }
                }
            }
        }
        if (!inRepository) {
            System.out.println("Nie znaleziono pojazdu o podanej tablicy rejestracyjnej");
        }
    }

    @Override
    public void getVehicles() {
        File CSVFile = new File(vehicleFile);
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
            System.out.println("Załadowano pojazdy");
            scanner.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Vehicle getVehicle(String licencePlate) {
        for (Vehicle v : vehicleList){
            if (v.getLicencePlate().equals(licencePlate)){
                return v;
            }
        }
        return null;
    }

    @Override
    public void save() {
        try {
            FileWriter writer = new FileWriter(vehicleFile, false);
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

    @Override
    public void addVehicle(Car car, String login) {
        User user = userRepository.getUser(login);
        if (user.getRola().equals("admin")) {
            vehicleList.add(car);
            save();
        } else {
            System.out.println("Nie masz uprawnień aby dodać pojazd");
        }
    }

    @Override
    public void removeVehicle(String licencePlate, String login) {
        User user = userRepository.getUser(login);
        Vehicle vehicleToRemove = getVehicle(licencePlate);
        if (vehicleList.contains(vehicleToRemove)) {
            if (user.getRola().equals("admin")) {
                vehicleList.remove(vehicleToRemove);
                System.out.println(user.getLogin() + " usunął pojazd o rejestracji " + vehicleToRemove.getLicencePlate());
                save();
            } else {
                System.out.println("Nie masz uprawnień aby usunąć pojazd");
            }
        } else {
            System.out.println("Nie istnieje podany pojazd");
        }
    }
}
