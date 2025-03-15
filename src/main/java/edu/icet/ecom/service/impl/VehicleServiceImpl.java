package edu.icet.ecom.service.impl;

import edu.icet.ecom.dto.Vehicle;
import edu.icet.ecom.entity.VehicleEntity;
import edu.icet.ecom.repository.VehicleRepository;
import edu.icet.ecom.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository repository;
    private final ModelMapper mapper;

    @Override
    public void addVehicle(Vehicle vehicle) {
        repository.save(mapper.map(vehicle, VehicleEntity.class));
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
    public void updateVehicle(Vehicle vehicle) {
        repository.save(mapper.map(vehicle,VehicleEntity.class));
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
