package com.example.library.Repository;

import com.example.library.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin,Integer> {
    public Optional<Admin> findById(int id);

    @Query(nativeQuery = true,value = "select * from admin where email_id=?1 order by id asc")
    Admin findByEmail(String email);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "update admin set password=?1 where id=?2")
    void changePassword(String pass,int id);
}
