package org.example;


import org.example.model.Car;
import org.example.model.User;
import org.example.model.Vehicle;

public interface IVehicleRepository {
    public void rentVehicle(String licencePlate, String login);
    public void returnVehicle(String licencePlate, String login);
    public void getVehicles();

    public Vehicle getVehicle(String licencePlate);

    public void save();

    public void addVehicle(Car car, String login);

    public void removeVehicle(String licencePlate, String login);
}
