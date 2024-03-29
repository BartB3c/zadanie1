package org.example;

import org.example.model.User;

import java.util.List;

public interface IUserRepository {
    public User getUser(String login);

    public List<User> getUsers();

    public void save();

    public void printUsersList(String login, VehicleRepository vehicleRepository);


}
