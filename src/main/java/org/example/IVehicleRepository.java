package org.example;


import org.example.model.Car;
import org.example.model.User;

public interface IVehicleRepository {
    public void rentCar(String licencePlate, User user);
    public void returnCar(String licencePlate, User user);
    public void getVehicles(String filepath);

    public void save(String filepath);

    public void addVehicle(Car car, User user);

    public void removeVehicle(Car car, User user);
}
