package com.example.library.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class StudentDto {
    private int id;
    private String studentName;
    private String emailId;
    private String year;
    private String department;
    private String password;
    private Long fineAmount;
}
