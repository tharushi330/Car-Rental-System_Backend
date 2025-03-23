package edu.icet.ecom.controller;

import edu.icet.ecom.dto.Vehicle;
import edu.icet.ecom.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class VehicleController {
    //    http://localhost:8080/vehicle/add

    private final VehicleService service;

    @PostMapping("/add")
    public void addVehicle(@RequestBody Vehicle vehicle){
        service.addVehicle(
                vehicle.getModel(),
                vehicle.getVehiclecategory(), // Added vehicletype
                vehicle.getBrand(),
                vehicle.getFuelType(),
                vehicle.getYear(),
                vehicle.getPricePerDay(),
                vehicle.getStatus(), // Now String
                vehicle.getImageURL(),
                vehicle.getDescription()
        );
    }

    @GetMapping("/get-all")
    public List<Vehicle> getAll(){
        return service.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteVehicle(@PathVariable Long id){
        service.deleteVehicle(id);
    }

    @PutMapping("/update-vehicle/{id}")
    public void updateVehicle(@RequestBody Vehicle vehicle, @PathVariable Long id){
        service.updateVehicle(vehicle, id);
    }

    @GetMapping("/search-by-id/{id}")
    public Vehicle searchById(@PathVariable Long id){
        return service.searchById(id);
    }

    @GetMapping("/search-by-model/{model}")
    public List<Vehicle> searchByModel(@PathVariable String model){
        return service.searchByModel(model);
    }

}