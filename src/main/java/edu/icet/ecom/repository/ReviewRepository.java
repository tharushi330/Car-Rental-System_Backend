package edu.icet.ecom.repository;

import edu.icet.ecom.entity.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewEntity, Long> {
    List<ReviewEntity> findByVehicleID(Long vehicleID);
    List<ReviewEntity> findByUserID(Long userID);

}
