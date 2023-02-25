package com.example.library.entity;

import com.example.library.miscellaneous.CommonStatus;
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
@Table(name = "student")
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "student_name")
    private String studentName;

    @Column(name="email_id")
    private String emailId;

    @Column(name = "password")
    private String password;

    @Column(name = "year")
    private String year;

    @Column(name = "department")
    private String department;

    @Column(name = "status")
    private String status;

    @Column(name = "fine_amount")
    private long fineAmount;
}
