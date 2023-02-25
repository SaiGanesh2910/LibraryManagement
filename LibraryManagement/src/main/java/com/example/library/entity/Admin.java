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
@Table(name = "admin")
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
public class Admin implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "admin_name")
    private String adminName;

    @Column(name="email_id")
    private String emailId;

    @Column(name = "password")
    private String password;

    @Column(name = "contact_no")
    private String contactNo;

    @Column(name = "status")
    private String  status;
}
