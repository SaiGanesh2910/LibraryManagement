package com.example.library.service;

import com.example.library.Repository.BookRepository;
import com.example.library.Repository.IssueRepository;
import com.example.library.Repository.StudentRepository;
import com.example.library.dto.StudentDto;
import com.example.library.entity.Book;
import com.example.library.entity.Issue;
import com.example.library.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepo;

    @Autowired
    IssueRepository issueRepo;

    public Student fetchStudentDetails(int id){
        return studentRepo.findById(id).get();
    }

    public boolean addStudent(StudentDto student){
        Student st = new Student();
        st.setStudentName(student.getStudentName());
        st.setDepartment(student.getDepartment());
        st.setEmailId(student.getEmailId());
        st.setPassword("123123123");
        st.setStatus("Active");
        st.setYear(student.getYear());
        st.setFineAmount(0l);
        studentRepo.save(st);
        return true;
    }

    public boolean changeStudentPassword(int id, String password) {
        studentRepo.changePassword(id,password);
        return true;
    }

    public boolean deactivate(int id) {
        String status="Deactivated";
        studentRepo.deactivate(id,status);
        return true;
    }

    public boolean addFine(StudentDto studentDto) {
        int id=studentDto.getId();
        long fine=studentDto.getFineAmount();
        Student st=studentRepo.findById(id).get();
        studentRepo.addFine(id,fine);
        System.out.println("Fine added to Student with Name "+st.getStudentName());
        return true;
    }

    public List<Student> getAllStudentDetails() {
        return studentRepo.findAll();
    }

    public boolean authenticateStudent(StudentDto studentDto) {
        String stEmail=studentDto.getEmailId();
        Student st=studentRepo.findByEmailId(stEmail);
        if(st==null)
            return false;
        if(st.getPassword().equals(studentDto.getPassword())){
            return true;
        }
        else{
            return false;
        }
    }

    public List<Issue> overDueList(int id) {
        List<Issue> bk=issueRepo.findByStudentId(id);
        return bk;
    }
}
