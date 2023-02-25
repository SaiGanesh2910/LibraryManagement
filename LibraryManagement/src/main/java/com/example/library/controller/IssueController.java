package com.example.library.controller;

import com.example.library.dto.BookDto;
import com.example.library.dto.IssueDto;
import com.example.library.entity.Issue;
import com.example.library.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/issue")
@CrossOrigin(origins = "http://localhost:4200")
public class IssueController {

    @Autowired
    IssueService issueService;

    @GetMapping("/allIssues")
    public List<Issue> getAllIssue(){
        return issueService.getAllIssues();
    }

    @PostMapping("/addIssue")
    public boolean addIssueRecord(@RequestBody IssueDto issueDto){
        return issueService.addIssueRecord(issueDto);
    }

    @PostMapping("addReturn")
    public boolean addReturnDate(@RequestBody IssueDto issueDto){
        return issueService.setReturnDate(issueDto);
    }

    @PostMapping("/booksByOneStudent")
    public List<Issue> booksBySt(@RequestBody BookDto bookDto){
        return issueService.BooksByStudent(bookDto);
    }
}
