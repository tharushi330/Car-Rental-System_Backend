package edu.icet.ecom.controller;

import edu.icet.ecom.dto.Vehicle;
import edu.icet.ecom.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
@RequiredArgsConstructor
@CrossOrigin
public class VehicleController {
    //    http://localhot:8080/vehicle/add

    private final VehicleService service;

    @PostMapping("/add")
    public void addVehicle(@RequestBody Vehicle vehicle){
        service.addVehicle(vehicle);
    }

    @GetMapping("/get-all")
    public List<Vehicle> getAll(){
        return service.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteVehicle(@PathVariable Long vehicleID){
        service.deleteVehicle(vehicleID);
    }

    @PutMapping("/update-vehicle")
    public void updateVehicle(@RequestBody Vehicle vehicle){
        service.updateVehicle(vehicle);
    }

    @GetMapping("/search-by-id/{id}")
    public Vehicle searchById(@PathVariable Long vehicleID){

        return service.searchById(vehicleID);
    }

    @GetMapping("/search-by-model/{model}")
    public List<Vehicle> searchByModel(@PathVariable String model){

        return service.searchByModel(model);
    }

}
