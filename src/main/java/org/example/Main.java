package org.example;

import org.example.model.Authentication;
import org.example.model.Car;
import org.example.model.User;

public class Main {
    public static void main(String[] args) {
//        String filename = "vehicles.csv";
//        VehicleRepository vehicleRepository = new VehicleRepository();
//        Car car1 = new Car("Toyota", "Corolla", 2018, 20000, "ABC123", false);
//        Car car2 = new Car("Honda", "Civic", 2019, 22000, "DEF456", false);
//        Motorcycle motorcycle1 = new Motorcycle("Harley-Davidson", "Sportster", 2020, 15000, "GHI789", true, "Cruiser");
//        Motorcycle motorcycle2 = new Motorcycle("Kawasaki", "Ninja", 2021, 18000, "JKL012", false, "Sport");
//
//        vehicleRepository.vehicleList = new ArrayList<>();
//
//        vehicleRepository.vehicleList.add(car1);
//        vehicleRepository.vehicleList.add(car2);
//        vehicleRepository.vehicleList.add(motorcycle1);
//        vehicleRepository.vehicleList.add(motorcycle2);
//        vehicleRepository.save(filename);
//        System.out.println("Przed wypożyczeniem: ");
//        for (Vehicle v : vehicleRepository.vehicleList){
//            System.out.println(v);
//        }
//        System.out.println("\n");
//        vehicleRepository.rentCar("ABC123");
//        vehicleRepository.rentCar("DEF456");
//        vehicleRepository.save(filename);
//        System.out.println("Po wypożyczeniu: ");
//        for (Vehicle v : vehicleRepository.vehicleList){
//            System.out.println(v);
//        }
//
//        System.out.println("\n");
//        System.out.println("Po zwrocie:");
//        vehicleRepository.returnCar("ABC123");
//        for (Vehicle v : vehicleRepository.vehicleList){
//            System.out.println(v);
//        }
        UserRepository userRepository = new UserRepository();
        Authentication authentication = new Authentication();
//        VehicleRepository vehicleRepository = new VehicleRepository();
//        User u1 = new User("WojtekZBombasu","wojtek1234","user");
//        User u2 = new User("MexicanoTv","mexico321","user");
//        User a1 = new User("Fiodorczuk","fiodor123","admin");

//        Authentication.login("WojtekZBombasu", "wojtek1234");
//        Authentication.login("Fiodorczuk","fiodor123");
//        userRepository.userList.add(u1);
//        userRepository.userList.add(u2);
//        userRepository.userList.add(a1);
//        userRepository.save(userFile);

//        Authentication.login("Fiodorczuk", "fiodor123");
//        vehicleRepository.rentVehicle("ABC123","WojtekZBombasu");
//        vehicleRepository.rentVehicle("GHI789","WojtekZBombasu");

//        userRepository.printUsersList("Fiodorczuk");
//        vehicleRepository.removeVehicle("JKL012","Fiodorczuk");
//        vehicleRepository.addVehicle(new Car("FSO","Polonez",1990,1000,"DJ47M",false), "Fiodorczuk");
//        userRepository
//        userRepository.userList.add(new User("tomek","123","user"));
//        userRepository.save();
//        vehicleRepository.rentVehicle("ABC123","tomek");
//        vehicleRepository.rentVehicle("DJ47M","Fiodorczuk");
        userRepository.printUsersList("Fiodorczuk");




    }
}