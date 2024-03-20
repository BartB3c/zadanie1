package org.example.model;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class User {
    private String login;
    private String password;

    private String rola;

    private String rentedCarPlate;

    private String hashedPassword;

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getRola() {
        return rola;
    }

    public String getRentedCarPlate() {
        return rentedCarPlate;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", rola='" + rola + '\'' +
                ", rentedCarPlate='" + rentedCarPlate + '\'' +
                '}';
    }

    public void setRola(String rola) {
        this.rola = rola;
    }

    public void setRentedCarPlate(String rentedCarPlate) {
        this.rentedCarPlate = rentedCarPlate;
    }

    public User(String login, String password, String rola, String rentedCarPlate) {
        this.login = login;
        this.password = password;
        this.rola = rola;
        this.rentedCarPlate = rentedCarPlate;
    }

    public User(String login, String password, String rola) {
        this.login = login;
        this.password = password;
        this.rola = rola;
    }

    public String toCSV() {
        return getLogin() +";"+getPassword()+";"+getRola()+";"+getRentedCarPlate();
    }

    public boolean checkPassword(String password) {
        return hashPassword(password).equals(hashedPassword);
    }

    private String hashPassword(String password) {
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
            e.printStackTrace();
            return null;
        }
    }



}
