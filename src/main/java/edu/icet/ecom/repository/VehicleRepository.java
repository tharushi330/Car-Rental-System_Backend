package edu.icet.ecom.repository;

import edu.icet.ecom.entity.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepository extends JpaRepository<VehicleEntity,Long> {
    List<VehicleEntity> findByModel(String model);
}
