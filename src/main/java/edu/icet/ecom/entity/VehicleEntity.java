package edu.icet.ecom.entity;

import edu.icet.ecom.util.VehicleStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "vehicle")
public class VehicleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vehicleID;
    private String model;
    private String brand;
    private String fuelType;
    private String year;
    private Double pricePerDay;

    @Enumerated(EnumType.STRING)
    private VehicleStatus status;

    private String imageURL;
    private String description;
}
