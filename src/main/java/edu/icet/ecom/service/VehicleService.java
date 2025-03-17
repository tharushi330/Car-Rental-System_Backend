package edu.icet.ecom.service;

import edu.icet.ecom.dto.Vehicle;
import edu.icet.ecom.util.VehicleStatus;

import java.util.List;

public interface VehicleService {
    void addVehicle(String model, String brand, String fuelType, String year, Double pricePerDay, String status, String imageURL, String description);

    List<Vehicle> getAll();

    void deleteVehicle(Long vehicleID);

    void updateVehicle(Vehicle vehicle, Long vehicleID);

    Vehicle searchById(Long vehicleID);

    List<Vehicle> searchByModel(String model);
}
