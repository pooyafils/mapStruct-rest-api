package com.spring.rest.mvc.springbootrest.domain;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class StudentRegistrationDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String familyName;
    private int studentNumber;
}
