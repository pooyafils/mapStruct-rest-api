package com.spring.rest.mvc.springbootrest.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class StudentRegistration {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String familyName;
    private int studentNumber;
}
