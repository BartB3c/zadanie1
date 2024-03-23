package org.example.model;



public class User {

    private String login;
    private final String password;

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
