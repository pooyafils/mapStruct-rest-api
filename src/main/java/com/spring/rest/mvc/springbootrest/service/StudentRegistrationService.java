package com.spring.rest.mvc.springbootrest.service;

import com.spring.rest.mvc.springbootrest.domain.StudentRegistrationDTO;

import java.util.List;

public interface StudentRegistrationService {
    StudentRegistrationDTO getByName(String name);
    List<StudentRegistrationDTO> getAllStudent();
    StudentRegistrationDTO createStudent(StudentRegistrationDTO  studentRegistrationDTO);
    StudentRegistrationDTO getById(int id);
    StudentRegistrationDTO saveStudentByDTO(Integer id,StudentRegistrationDTO studentRegistrationDTO);
}
