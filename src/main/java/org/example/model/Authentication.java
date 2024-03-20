package org.example.model;

import java.util.Scanner;

public class Authentication {

    private static final String dataFile = "users.csv";


    public static boolean login(String login, String password) {
        Scanner fileScanner = new Scanner(dataFile);
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            String[] data = line.split(";");
            User user = new User(data[0],data[1],data[2]);
            if (user.getLogin().equals(login) && user.checkPassword(password)){
                System.out.println("Zalogowano pomyślnie");
                return true;
            }
        }
        System.out.println("Zły login lub hasło");
        return false;
    }

}
