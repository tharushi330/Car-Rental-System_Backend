package edu.icet.ecom.service.impl;

import edu.icet.ecom.dto.Vehicle;
import edu.icet.ecom.entity.VehicleEntity;
import edu.icet.ecom.repository.VehicleRepository;
import edu.icet.ecom.service.VehicleService;
import edu.icet.ecom.util.VehicleStatus;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository repository;
    private final ModelMapper mapper;

    @Override
    public void addVehicle(String model, String brand, String fuelType, String year, Double pricePerDay, String statusStr, String imageURL, String description) {
        VehicleEntity vehicleEntity = new VehicleEntity();
        vehicleEntity.setModel(model);
        vehicleEntity.setBrand(brand);
        vehicleEntity.setFuelType(fuelType);
        vehicleEntity.setYear(year);
        vehicleEntity.setPricePerDay(pricePerDay);

        try {
            VehicleStatus status = VehicleStatus.valueOf(statusStr.toUpperCase().trim());
            vehicleEntity.setStatus(status);
        } catch (IllegalArgumentException | NullPointerException e) {
            throw new RuntimeException("Invalid vehicle status: " + statusStr);
        }

        vehicleEntity.setImageURL(imageURL);
        vehicleEntity.setDescription(description);
        repository.save(vehicleEntity);

    }



    @Override
    public List<Vehicle> getAll() {
        List<Vehicle> vehicleList = new ArrayList<>();
        List<VehicleEntity> all = repository.findAll();

        all.forEach(vehicleEntity -> {
            vehicleList.add(mapper.map(vehicleEntity, Vehicle.class));
        });

        return vehicleList;
    }

    @Override
    public void deleteVehicle(Long vehicleID) {
        repository.deleteById(vehicleID);
    }


    @Override
    public void updateVehicle(Vehicle vehicle,Long vehicleID) {
        Optional<VehicleEntity> sOpt = repository.findById(vehicleID);

        if (sOpt.isPresent()) {
            VehicleEntity existCus = sOpt.get();
            existCus.setModel(vehicle.getModel());
            existCus.setBrand(vehicle.getBrand());
            existCus.setFuelType(vehicle.getFuelType());
            existCus.setYear(vehicle.getYear());
            existCus.setPricePerDay(vehicle.getPricePerDay());

            // Convert status safely
            try {
                VehicleStatus status = VehicleStatus.valueOf(vehicle.getStatus().toUpperCase().trim());
                existCus.setStatus(status);
            } catch (IllegalArgumentException | NullPointerException e) {
                throw new RuntimeException("Invalid vehicle status: " + vehicle.getStatus());
            }

            existCus.setImageURL(vehicle.getImageURL());
            existCus.setDescription(vehicle.getDescription());

            repository.save(existCus);
        } else {
            throw new EntityNotFoundException("Vehicle with ID " + vehicleID + " not found.");
        }
    }

    @Override
    public Vehicle searchById(Long vehicleID) {
        return mapper.map(repository.findById(vehicleID), Vehicle.class);
    }


    @Override
    public List<Vehicle> searchByModel(String model) {
        List<VehicleEntity> byModel = repository.findByModel(model);
        List<Vehicle> vehicleList = new ArrayList<>();

        byModel.forEach(vehicleEntity -> {
            vehicleList.add(mapper.map(vehicleEntity, Vehicle.class));
        });
        return vehicleList;
    }
}
