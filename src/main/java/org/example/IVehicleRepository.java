package org.example;


public interface IVehicleRepository {
    public void rentCar(String licencePlate);
    public void returnCar(String licencePlate);
    public void getVehicles(String filepath);

    public void save(String filepath);
}
