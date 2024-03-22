package org.example.model;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class User {

    private Authentication authentication;
    private String login;
    private String password;

    private String rola;

    private String rentedCarPlate;


    public String getPassword() {
        return password;
    }

    public String getLogin() {
        return login;
    }


    public String getRola() {
        return rola;
    }

    public String getRentedCarPlate() {
        return rentedCarPlate;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setRola(String rola) {
        this.rola = rola;
    }

    public void setRentedCarPlate(String rentedCarPlate) {
        this.rentedCarPlate = rentedCarPlate;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", rola='" + rola + '\'' +
                ", rentedCarPlate='" + rentedCarPlate + '\'' +
                '}';
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
        String hashedPassword = Authentication.hashPassword(getPassword());
        return getLogin() + ";" + hashedPassword + ";" + getRola() + ";" + getRentedCarPlate();
    }
}
