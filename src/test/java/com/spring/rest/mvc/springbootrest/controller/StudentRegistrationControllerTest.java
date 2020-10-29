package com.spring.rest.mvc.springbootrest.controller;

/*import com.spring.rest.mvc.springbootrest.domain.StudentRegistration;
import com.spring.rest.mvc.springbootrest.domain.StudentRegistrationDTO;
import com.spring.rest.mvc.springbootrest.service.StudentRegistrationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;*/

import com.spring.rest.mvc.springbootrest.domain.StudentRegistrationDTO;
import com.spring.rest.mvc.springbootrest.service.StudentRegistrationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.json.BasicJsonParser;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
////////////////////////////////////

class StudentRegistrationControllerTest {
    @Mock
    StudentRegistrationService studentRegistrationService;
    @InjectMocks
    StudentRegistrationController studentRegistrationController;

    MockMvc mockMvc;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc= MockMvcBuilders.standaloneSetup(studentRegistrationController).build();

    }

    @Test
    void getAllStudent() throws Exception {
        StudentRegistrationDTO studentRegistration=new StudentRegistrationDTO();
        studentRegistration.setId(122);
        studentRegistration.setName("pooya");
        studentRegistration.setFamilyName("fils");
        studentRegistration.setStudentNumber(1212);

        StudentRegistrationDTO studentRegistration1=new StudentRegistrationDTO();
        studentRegistration1.setId(142);
        studentRegistration1.setName("spring");
        studentRegistration1.setStudentNumber(12134);
        studentRegistration1.setFamilyName("lolo");
        List<StudentRegistrationDTO> students= Arrays.asList(studentRegistration,studentRegistration1);
        when(studentRegistrationService.getAllStudent()).thenReturn(students);
        mockMvc.perform(get("/student/students").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

              //  .andExpect(jsonPath("$.students",hasSize(2)));
    }
    @Test
    void getByName()  throws Exception {
        StudentRegistrationDTO studentRegistration=new StudentRegistrationDTO();
        studentRegistration.setId(122);
        studentRegistration.setName("pooya");
        studentRegistration.setFamilyName("fils");
        studentRegistration.setStudentNumber(1212);
        when(studentRegistrationService.getByName(anyString())).thenReturn(studentRegistration);
        mockMvc.perform(get("/student/pooya").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name",equalTo("pooya")));
    }

    @Test
    void createStudent() {
    }
    @Test
    void StudentRegistrationDTO() throws Exception {
        StudentRegistrationDTO studentRegistration=new StudentRegistrationDTO();
        studentRegistration.setId(100);
        studentRegistration.setName("pooya");
        studentRegistration.setFamilyName("fils");
        studentRegistration.setStudentNumber(1212);
        when(studentRegistrationService.getById(anyInt())).thenReturn(studentRegistration);
        mockMvc.perform(get("/student/findbyid/100").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name",equalTo("pooya")));
    }
    @Test
    public void testUpdateCustomer() throws Exception {
        StudentRegistrationDTO studentRegistration=new StudentRegistrationDTO();
        studentRegistration.setId(120);
        studentRegistration.setName("spring");
        studentRegistration.setFamilyName("fils");
        studentRegistration.setStudentNumber(122);

        StudentRegistrationDTO returnstudentRegistration=new StudentRegistrationDTO();
        returnstudentRegistration.setFamilyName(studentRegistration.getFamilyName());
        returnstudentRegistration.setName(studentRegistration.getName());
        returnstudentRegistration.setStudentNumber(177);
        returnstudentRegistration.setId(118);
        when(studentRegistrationService.saveStudentByDTO(anyInt(),any(StudentRegistrationDTO.class)))
                .thenReturn(returnstudentRegistration);
        mockMvc.perform(put("/student/112")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(studentRegistration))


    }

}