package org.example;

import org.example.model.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class UserRepository implements IUserRepository {

    private final String filepath = "users.csv";

    private static List<User> userList;
    @Override
    public User getUser(String login) {
       if (!userList.isEmpty()){
           for (User user : userList){
               if (login == user.getLogin()){
                   return user;
               } else {
                   System.out.println("Nie znaleziono użytkownika o takim loginie");
               }
           }
       }
        return null;
    }

    @Override
    public List<User> getUsers() {
        File CSVFile = new File(filepath);
        try {
            Scanner scanner = new Scanner(CSVFile);
            while (scanner.hasNextLine()){
                String line  = scanner.nextLine();
                String[] data = line.split(";");
                String login = data[0];
                String password = data[1];
                String rola = data[2];
                String rentedVehiclePlate = data[3];
                userList.add(new User(login,password,rola,rentedVehiclePlate));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return userList;
    }

    @Override
    public void save(String filePath) {
        try {
            FileWriter writer = new FileWriter(filePath);
            for (User user : userList){
                String data = user.toCSV();
                writer.write(data);
                System.out.println("Zapisano użytkowników");
                writer.close();
            }
        } catch (IOException e) {
            System.err.println("Błąd podczas zapisu do pliku CSV: " + e.getMessage());
        }
    }

    public void printUsersList(User user){
        if (user.getRola().equals("admin")){
            for (User u : userList){
                u.toString();
            }
        } else {
            System.out.println("Nie masz uprawnień do wyświetlenia listy użytkowników");
        }
    }


}
