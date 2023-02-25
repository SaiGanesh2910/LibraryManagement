package com.example.library.controller;

import com.example.library.dto.StudentDto;
import com.example.library.entity.Book;
import com.example.library.entity.Issue;
import com.example.library.entity.Student;
import com.example.library.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {
    private static final Logger logger= LoggerFactory.getLogger(StudentController.class);
    @Autowired
    StudentService studentService;

    @GetMapping(value = "/details")
    public Student getStudentDetails(@RequestParam int id){
        return studentService.fetchStudentDetails(id);
    }

    @PostMapping("/add")
    public boolean addStudent(@RequestBody StudentDto student){
        logger.info("Adding Student");
        boolean b=studentService.addStudent(student);
        if(b){
            logger.info("Student added successfully");
        }
        else{
            logger.info("Student didn't added to db");
        }
        return b;
    }

    @PostMapping("/changePassword")
    public boolean changePassword(@RequestBody StudentDto studentDto){
        int id=studentDto.getId();
        String password=studentDto.getPassword();
        return studentService.changeStudentPassword(id,password);
    }

    @PostMapping("/deactivate")
    public boolean deactivateStudent(@RequestParam int id){
        logger.info("Deactivating student with id = "+id);
        return studentService.deactivate(id);
    }

    @PostMapping(value = "/addFine")
    public boolean addFineToStudent(@RequestBody StudentDto studentDto){
        logger.info("Adding Fine to student with id "+studentDto.getId());
        return studentService.addFine(studentDto);
    }

    @GetMapping("/getAll")
    public List<Student> getAllStudentDetails(){
        return studentService.getAllStudentDetails();
    }

    @PostMapping("/login")
    public boolean authenticate(@RequestBody StudentDto studentDto)throws Exception{
        return studentService.authenticateStudent(studentDto);
    }

    @PostMapping("/overDue")
    public List<Issue> overDue(@RequestParam int id){
        return studentService.overDueList(id);
    }
}
