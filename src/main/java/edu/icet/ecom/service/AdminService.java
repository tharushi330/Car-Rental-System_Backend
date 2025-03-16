package edu.icet.ecom.service;

import edu.icet.ecom.dto.Admin;

import java.util.List;

public interface AdminService {
    Admin saveAdmin(Admin admin);          // Accept & return DTO
    List<Admin> getAllAdmins();
    Admin getAdminById(Long id);
    Admin updateAdmin(Long id, Admin admin);
    void deleteAdmin(Long id);
    Admin getAdminByName(String adminName);

}
