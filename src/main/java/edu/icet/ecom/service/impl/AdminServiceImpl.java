package edu.icet.ecom.service.impl;

import edu.icet.ecom.dto.Admin;
import edu.icet.ecom.entity.AdminEntity;
import edu.icet.ecom.repository.AdminRepository;
import edu.icet.ecom.repository.BookingRepository;
import edu.icet.ecom.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final AdminRepository adminRepository;
    private final ModelMapper modelMapper;

    @Override
    public Admin saveAdmin(Admin admin) {
        AdminEntity entity = modelMapper.map(admin, AdminEntity.class);
        AdminEntity savedEntity = adminRepository.save(entity);
        return modelMapper.map(savedEntity, Admin.class);
    }

    @Override
    public List<Admin> getAllAdmins() {
        List<AdminEntity> entities = adminRepository.findAll();
        return entities.stream()
                .map(entity -> modelMapper.map(entity, Admin.class))
                .collect(Collectors.toList());
    }

    @Override
    public Admin getAdminById(Long id) {
        AdminEntity entity = adminRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Admin not found with ID: " + id));
        return modelMapper.map(entity, Admin.class);
    }

    @Override
    public Admin updateAdmin(Long id, Admin admin) {
        AdminEntity existingEntity = adminRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Admin not found with ID: " + id));

        modelMapper.map(admin, existingEntity);
        AdminEntity updatedEntity = adminRepository.save(existingEntity);
        return modelMapper.map(updatedEntity, Admin.class);
    }

    @Override
    public void deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }

    @Override
    public Admin getAdminByName(String adminName) {
        AdminEntity entity = adminRepository.findByAdminName(adminName)
                .orElseThrow(() -> new RuntimeException("Admin not found with Name: " + adminName));
        return modelMapper.map(entity, Admin.class);

    }
}
