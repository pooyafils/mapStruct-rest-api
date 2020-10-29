package com.spring.rest.mvc.springbootrest.service;

import com.spring.rest.mvc.springbootrest.domain.StudentRegistration;
import com.spring.rest.mvc.springbootrest.domain.StudentRegistrationDTO;
import com.spring.rest.mvc.springbootrest.mapper.StudentRegistrationMapper;
import com.spring.rest.mvc.springbootrest.repository.StudentRegistrationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class StudentRegistrationServiceImplTest {
    public static final Long ID = 2L;
    public static final String NAME = "Jimmy";
    StudentRegistrationService studentRegistrationService;
    @Mock
    StudentRegistrationRepository studentRegistrationRepository;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        studentRegistrationService=new StudentRegistrationServiceImpl(
    studentRegistrationRepository,StudentRegistrationMapper.INSTANCE);
    }

    @Test
    void getByName() {
    }

    @Test
    void getAllStudent() throws Exception {
        List<StudentRegistration> studentRegistrations= Arrays.asList(new StudentRegistration(),
                new StudentRegistration());
        when(studentRegistrationRepository.findAll()).thenReturn(studentRegistrations);
        List<StudentRegistrationDTO> studentRegistrations1=studentRegistrationService.getAllStudent();
        assertEquals(2,studentRegistrations1.size());
    }

    @Test
    void createStudent() {
    }

    @Test
    void saveAndReturn() throws Exception{
        StudentRegistration studentRegistration=new StudentRegistration();
        studentRegistration.setId(1);
        studentRegistration.setName("pooya");
        when(studentRegistrationRepository.findByName(anyString())).thenReturn(studentRegistration);
        StudentRegistrationDTO studentRegistrationDTO=studentRegistrationService.getByName("pooya");
        assertEquals(1,studentRegistrationDTO.getId());
        assertEquals("pooya",studentRegistrationDTO.getName());
    }
}