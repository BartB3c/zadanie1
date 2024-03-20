package org.example.model;

import java.util.Scanner;

public class Authentication {

    private static final String dataFile = "users.csv";


    public static boolean login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Login:");
        String login = scanner.nextLine();
        System.out.println("Hasło:");
        String password = scanner.nextLine();
        Scanner fileScanner = new Scanner(dataFile);
        while (fileScanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] data = line.split(";");
            if (data.length == 3) {
                User user = new User(data[0], data[1], data[2]);
                if (user.getLogin().equals(login) && user.checkPassword(password)){
                    System.out.println("Zalogowano pomyślnie:");
                    return true;
                }
            }
        }
        System.out.println("Zły login lub hasło");
        return false;
    }

}
