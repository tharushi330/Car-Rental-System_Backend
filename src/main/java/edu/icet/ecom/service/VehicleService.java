package edu.icet.ecom.service;

import edu.icet.ecom.dto.Vehicle;

import java.util.List;

public interface VehicleService {
    void addVehicle(Vehicle vehicle);

    List<Vehicle> getAll();

    void deleteVehicle(Long vehicleID);

    void updateVehicle(Vehicle vehicle);

    Vehicle searchById(Long vehicleID);

    List<Vehicle> searchByModel(String model);
}
