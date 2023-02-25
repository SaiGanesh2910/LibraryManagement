package com.example.library.service;

import com.example.library.Repository.AdminRepository;
import com.example.library.dto.AdminDto;
import com.example.library.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    AdminRepository adminRepo;
    public Admin getAdminDetails(int id) {
        return adminRepo.findById(id).get();
    }

    public boolean addAdmin(AdminDto adminDto){
        Admin admin=new Admin();
        admin.setAdminName(adminDto.getAdminName());
        admin.setEmailId(adminDto.getEmailId());
        admin.setPassword("123456");
        admin.setStatus(adminDto.getStatus());
        admin.setContactNo(adminDto.getContactNo());
        adminRepo.save(admin);
        return true;
    }

    public boolean validateLogin(AdminDto adminDto) {
        String email=adminDto.getEmailId();
        String pass=adminDto.getPassword();
        Admin admin=adminRepo.findByEmail(email);
        if(admin==null)
            return false;
        if (pass.equals(admin.getPassword())){
            return true;
        }else{
            return false;
        }
    }

    public boolean changePassword(AdminDto adminDto) {
        String pass=adminDto.getPassword();
        int id=adminDto.getId();
        adminRepo.changePassword(pass,id);
        return true;
    }
}
