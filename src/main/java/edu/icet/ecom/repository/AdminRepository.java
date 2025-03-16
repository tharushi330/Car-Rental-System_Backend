package edu.icet.ecom.repository;

import edu.icet.ecom.entity.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface AdminRepository extends JpaRepository <AdminEntity, Long>{
    Optional<AdminEntity> findByAdminName(String adminName);
}
