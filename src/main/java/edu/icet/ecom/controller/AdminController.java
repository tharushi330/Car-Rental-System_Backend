package edu.icet.ecom.controller;

import edu.icet.ecom.dto.Admin;
import edu.icet.ecom.service.AdminService;
import edu.icet.ecom.service.BookingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admins")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class AdminController {
    private final AdminService adminService;

    @PostMapping("/add")
    public Admin saveAdmin(@Valid @RequestBody Admin admin) {
        return adminService.saveAdmin(admin);
    }

    @GetMapping("/get-all")
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    @GetMapping("/search-by-id/{id}")
    public Admin getAdminById(@PathVariable Long id) {
        return adminService.getAdminById(id);
    }

    @PutMapping("/update-admin")
    public Admin updateAdmin(@PathVariable Long id, @Valid @RequestBody Admin admin) {
        return adminService.updateAdmin(id, admin);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteAdmin(@PathVariable Long id) {
        adminService.deleteAdmin(id);
        return "Admin deleted successfully";
    }

    @GetMapping("/search-by-name/{adminName}")
    public Admin getAdminByName(@PathVariable String adminName) {
        return adminService.getAdminByName(adminName);
    }

}
