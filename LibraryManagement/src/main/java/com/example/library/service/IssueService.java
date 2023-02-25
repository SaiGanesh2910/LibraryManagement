package com.example.library.service;

import com.example.library.Repository.BookRepository;
import com.example.library.Repository.IssueRepository;
import com.example.library.dto.BookDto;
import com.example.library.dto.IssueDto;
import com.example.library.entity.Book;
import com.example.library.entity.Issue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class IssueService {

    @Autowired
    IssueRepository issueRepo;

    @Autowired
    BookRepository bookRepo;

    public List<Issue> getAllIssues() {
        return issueRepo.findAll();
    }

    public boolean addIssueRecord(IssueDto issueDto) {
        Issue issue = new Issue();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        Date date=cal.getTime();
        String strDate = dateFormat.format(date);
        cal.add(Calendar.DAY_OF_MONTH,15);
        String dueDate=dateFormat.format(cal.getTime());
        issue.setIssueDate(strDate);
        issue.setDueDate(dueDate);
        issue.setStudentId(issueDto.getStudentId());
        Book bk=bookRepo.findById(issueDto.getBookId()).get();
        bookRepo.setAvailable(issueDto.getBookId(),false);
        if(bk.isAvailable())
            issue.setBookId(issueDto.getBookId());
        else
            return false;
        Issue isNew=issueRepo.save(issue);
        return isNew!=null?true:false;
    }

    public boolean setReturnDate(IssueDto issueDto){
        int bookId=issueDto.getBookId();
        int studentId=issueDto.getStudentId();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal=Calendar.getInstance();
        bookRepo.setAvailable(bookId,true);
        String returnDate =dateFormat.format(cal.getTime());
        issueRepo.setReturnDate(bookId,studentId,returnDate);
        return true;
    }

    public List<Issue> BooksByStudent(BookDto bookDto) {
        int studentId=bookDto.getStudentId();
        List<Issue> issues=issueRepo.findByStudent(studentId);
        return issues;
    }
}
