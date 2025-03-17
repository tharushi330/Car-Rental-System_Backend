package edu.icet.ecom.dto;

import edu.icet.ecom.util.VehicleStatus;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.annotations.NotFound;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Vehicle {
    @NotEmpty(message = "This should not be blank")
    private Long vehicleID;

    @NotEmpty(message = "This should not be blank")
    private String model;

    @NotEmpty(message = "This should not be blank")
    private String brand;

    @NotEmpty(message = "This should not be blank")
    private String fuelType;

    @NotEmpty(message = "This should not be blank")
    private String year;

    @NotEmpty(message = "This should not be blank")
    private Double pricePerDay;

    @NotEmpty(message = "This should not be blank")
    private String status; // Change from VehicleStatus to String

    @NotEmpty(message = "This should not be blank")
    private String imageURL;

    @NotEmpty(message = "This should not be blank")
    private String description;
}
