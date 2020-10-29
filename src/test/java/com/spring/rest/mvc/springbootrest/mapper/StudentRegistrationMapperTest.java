package com.spring.rest.mvc.springbootrest.mapper;

import com.spring.rest.mvc.springbootrest.domain.StudentRegistration;
import com.spring.rest.mvc.springbootrest.domain.StudentRegistrationDTO;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentRegistrationMapperTest {
public static final String NAME="joe";
StudentRegistrationMapper studentRegistrationMapper=StudentRegistrationMapper.INSTANCE;

    @BeforeEach
    void setUp() {
    }

    @Test
    void studentRegistrationToStudentRegistrationDTO() {
        //given
        StudentRegistration studentRegistration=new StudentRegistration();
        studentRegistration.setFamilyName(NAME);
        studentRegistration.setName(NAME);
        studentRegistration.setId(1);
        //when
        StudentRegistrationDTO studentRegistrationDTO=studentRegistrationMapper.studentRegistrationToStudentRegistrationDTO(studentRegistration);
        assertEquals(NAME,studentRegistrationDTO.getName());
        assertEquals(1,studentRegistrationDTO.getId());
    }

    @Test
    void studentRegistrationDTOToStudentRegistration() {
    }
}