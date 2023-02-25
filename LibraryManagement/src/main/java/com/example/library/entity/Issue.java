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
@Table(name = "issue")
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
public class Issue implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "issue_date")
    private String issueDate;

    @Column(name="due_date")
    private String dueDate;

    @Column(name = "return_date")
    private String returnDate;

    @Column(name = "student_id")
    private int studentId;

    @Column(name = "book_id")
    private int bookId;
}
