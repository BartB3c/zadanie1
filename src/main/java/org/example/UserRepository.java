package org.example;

import org.example.model.Car;
import org.example.model.User;
import org.example.model.Vehicle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.UnknownServiceException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class UserRepository implements IUserRepository {

    private final String filePath = "users.csv";
    private List<User> userList;

    public UserRepository() {
        this.userList = new ArrayList<>();
        getUsers();
    }

    @Override
    public User getUser(String login) {
        for (User user : userList) {
            if (login.equals(user.getLogin())) {
                return user;
            }
        }
        System.out.println("Nie znaleziono użytkownika o takim loginie");
        return null;
    }

    @Override
    public List<User> getUsers() {
        File CSVFile = new File(filePath);
        try {
            Scanner scanner = new Scanner(CSVFile);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(";");
                String login = data[0];
                String hashedPassword = data[1];
                String rola = data[2];
                String rentedVehiclePlate = data[3];
                userList.add(new User(login, hashedPassword, rola, rentedVehiclePlate));
            }
//            System.out.println("Załadowano użytkowników");
            scanner.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return userList;
    }

    @Override
    public void save() {
        try {
            FileWriter writer = new FileWriter(filePath, false);
            for (User user : userList) {
                writer.write(user.toCSV() + "\n");
//                System.out.println("Zapisano użytkownika: " + user.getLogin());
            }
            writer.close();
        } catch (IOException e) {
            System.err.println("Błąd podczas zapisu do pliku CSV: " + e.getMessage());
        }
    }

    public void printUsersList(String login, VehicleRepository vehicleRepository) {
        User user = getUser(login);
        if (user.getRola().equals("admin")) {
            System.out.println("Użytkownicy w bazie:");
            for (User u : userList) {
                String rentedCarPlate = u.getRentedCarPlate();
                System.out.println(u);
                if (!rentedCarPlate.equals("null")) {
                    Vehicle vehicle = vehicleRepository.getVehicle(rentedCarPlate);
                    System.out.println(vehicle);
                }
            }
        } else {
            System.out.println("Twoje dane");
            System.out.println(user);
            Vehicle vehicle = vehicleRepository.getVehicle(user.getRentedCarPlate());
            System.out.println(vehicle);

        }
    }


}
