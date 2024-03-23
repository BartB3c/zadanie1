package org.example.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Authentication {

    private static final String dataFile = "users.csv";

    public static boolean login(String login, String password) {
        File usersFile = new File(dataFile);
        try (Scanner fileScanner = new Scanner(usersFile)) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] data = line.split(";");
                String storedLogin = data[0];
                String storedHashedPassword = data[1];
                if (login.equals(storedLogin)) {
                    if (verifyPassword(password, storedHashedPassword)) {
                        System.out.println("Zalogowano pomyślnie!");
                        return true;
                    } else {
                        System.out.println("Zły login lub hasło");
                        return false;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public static boolean verifyPassword(String password, String storedHashPassword) {
        String hashedPassword = hashPassword(password);
        return hashedPassword.equals(storedHashPassword);
    }

    public static String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedHash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder(2 * encodedHash.length);
            for (byte b : encodedHash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Błąd podczas szyfrowania hasła: " + e.getMessage());
            return null;
        }
    }
}
