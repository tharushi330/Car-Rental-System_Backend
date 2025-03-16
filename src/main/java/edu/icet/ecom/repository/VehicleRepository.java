package edu.icet.ecom.repository;

import edu.icet.ecom.entity.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<VehicleEntity,Long> {
    List<VehicleEntity> findByModel(String model);
}
