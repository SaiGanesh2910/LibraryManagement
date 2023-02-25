package com.example.library.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class IssueDto {
    private int id;
    private int bookId;
    private int studentId;
    private String dueDate;
    private String issueDate;
    private String returnDate;
}
