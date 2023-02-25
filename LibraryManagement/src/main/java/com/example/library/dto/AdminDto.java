package com.example.library.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdminDto {

    private int id;
    private String adminName;
    private String emailId;
    private String status;
    private String contactNo;
    private String password;
}
