package com.example.library.Repository;

import com.example.library.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,Integer> {
    public Optional<Student> findById(int id);
    @Modifying
    @Transactional
    @Query(nativeQuery = true,value = "update student set password=?2 where id =?1")
    public void changePassword(int id, String password);

    @Modifying
    @Transactional
    @Query(nativeQuery = true,value = "update student set status=?2 where id =?1")
    public void deactivate(int id,String status);

    @Modifying
    @Transactional
    @Query(nativeQuery = true,value = "update student set fine_amount=?2 where id =?1")
    public void addFine(int id, long fine);

    @Query(nativeQuery = true,value = "select * from student where email_id=?1")
    public Student findByEmailId(String emailId);
}
