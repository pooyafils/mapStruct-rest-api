package com.spring.rest.mvc.springbootrest.service;

import com.spring.rest.mvc.springbootrest.domain.StudentRegistration;
import com.spring.rest.mvc.springbootrest.domain.StudentRegistrationDTO;
import com.spring.rest.mvc.springbootrest.mapper.StudentRegistrationMapper;
import com.spring.rest.mvc.springbootrest.repository.StudentRegistrationRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentRegistrationServiceImpl implements StudentRegistrationService {
 private final    StudentRegistrationRepository studentRegistrationRepository;
 private final    StudentRegistrationMapper studentRegistrationMapper;

    public StudentRegistrationServiceImpl(StudentRegistrationRepository studentRegistrationRepository, StudentRegistrationMapper studentRegistrationMapper) {
        this.studentRegistrationRepository = studentRegistrationRepository;
        this.studentRegistrationMapper = studentRegistrationMapper;
    }

    @Override
    public StudentRegistrationDTO getByName(String name) {
        return studentRegistrationMapper.studentRegistrationToStudentRegistrationDTO(
                studentRegistrationRepository.findByName(name));
    }

    @Override
    public List<StudentRegistrationDTO> getAllStudent() {
        return studentRegistrationRepository.findAll().stream().map(studentRegistration -> {
            StudentRegistrationDTO studentregistrationDTO =
                    studentRegistrationMapper.studentRegistrationToStudentRegistrationDTO(studentRegistration);
            return studentregistrationDTO;
        })
                .collect(Collectors.toList());
    }

    @Override
    public StudentRegistrationDTO createStudent(StudentRegistrationDTO studentRegistrationDTO) {
        return saveAndReturn(studentRegistrationMapper.StudentRegistrationDTOToStudentRegistration(studentRegistrationDTO));

    }

    @Override
    public StudentRegistrationDTO getById(int id) {
        return studentRegistrationMapper.studentRegistrationToStudentRegistrationDTO(studentRegistrationRepository.findById(id));
    }

    @Override
    public StudentRegistrationDTO saveStudentByDTO(Integer id, StudentRegistrationDTO studentRegistrationDTO) {
        StudentRegistration student=studentRegistrationMapper.StudentRegistrationDTOToStudentRegistration(studentRegistrationDTO);
        student.setId(id);
        return saveAndReturn(student);
    }

    @Override
    public StudentRegistrationDTO patchCustomer(int id, StudentRegistrationDTO studentRegistrationDTO)  {
 Integer ids=id;
   return  studentRegistrationRepository.findById(ids).map(studentregisterargs -> {

       if(studentRegistrationDTO.getName() != null){
           studentregisterargs.setName(studentRegistrationDTO.getName());
       }

       if(studentRegistrationDTO.getFamilyName() != null){
           studentregisterargs.setFamilyName(studentregisterargs.getFamilyName());
       }

       StudentRegistrationDTO returns=studentRegistrationMapper.
               studentRegistrationToStudentRegistrationDTO
                       (studentRegistrationRepository.save(studentregisterargs));
      return returns;
           }).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public void deleteStudentById(int id)  {
        studentRegistrationRepository.deleteById(id);
    }

    public StudentRegistrationDTO saveAndReturn(StudentRegistration studentRegistration){
        StudentRegistration studentRegistration1=studentRegistrationRepository.save(studentRegistration);
        StudentRegistrationDTO studentRegistrationDTOsave=studentRegistrationMapper.studentRegistrationToStudentRegistrationDTO(studentRegistration1);
        return studentRegistrationDTOsave;
    }


}
