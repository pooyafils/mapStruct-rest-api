package com.spring.rest.mvc.springbootrest.mapper;

import com.spring.rest.mvc.springbootrest.domain.StudentRegistration;
import com.spring.rest.mvc.springbootrest.domain.StudentRegistrationDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentRegistrationMapper {
        StudentRegistrationMapper INSTANCE= Mappers.getMapper(StudentRegistrationMapper.class);
        StudentRegistrationDTO  studentRegistrationToStudentRegistrationDTO(StudentRegistration StudentRegistration);
    StudentRegistration StudentRegistrationDTOToStudentRegistration(StudentRegistrationDTO  studentRegistrationDTO);

}
