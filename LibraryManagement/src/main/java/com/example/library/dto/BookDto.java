package com.example.library.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookDto {

    private int id;
    private String bookName;
    private String author;
    private String edition;
    private String category;
    private String serialNo;
    private int bookId;
    private boolean isAvailable;
    private int studentId;
}
