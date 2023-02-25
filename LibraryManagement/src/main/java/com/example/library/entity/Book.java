package com.example.library.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@AllArgsConstructor
@Builder
@Table(name = "book")
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
public class Book implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "book_name")
    private String bookName;

    @Column(name="author")
    private String author;

    @Column(name = "edition")
    private String edition;

    @Column(name = "category")
    private String category;

    @Column(name = "serial_no")
    private String serialNo;

    @Column(name = "is_available")
    private boolean isAvailable;
}
