package com.example.library.controller;

import com.example.library.dto.AdminDto;
import com.example.library.entity.Admin;
import com.example.library.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/admin")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {

    @Autowired
    AdminService adminService;

    @GetMapping("/{id}")
    public Admin getAdminDetails(@RequestParam int id){
        return adminService.getAdminDetails(id);
    }

    @PostMapping("/addAdmin")
    public boolean addAdmin(@RequestBody AdminDto adminDto){
        boolean b= adminService.addAdmin(adminDto);
        if(b)
            return true;
        else
            return false;
    }

    @PostMapping("/login")
    public boolean validateLogin(@RequestBody AdminDto adminDto){
        return adminService.validateLogin(adminDto);
    }

    @PostMapping("/changePass")
    public boolean changePass(@RequestBody AdminDto adminDto){
        return adminService.changePassword(adminDto);
    }
}
