package com.spring.rest.mvc.springbootrest.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class StudentRegistrationDTOList {
    List<StudentRegistrationDTO> studentRegistrationDTOList;
}
