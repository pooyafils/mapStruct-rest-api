package com.spring.rest.mvc.springbootrest.controller;

import com.spring.rest.mvc.springbootrest.domain.StudentRegistrationDTO;
import com.spring.rest.mvc.springbootrest.domain.StudentRegistrationDTOList;
import com.spring.rest.mvc.springbootrest.repository.StudentRegistrationRepository;
import com.spring.rest.mvc.springbootrest.service.ResourceNotFoundException;
import com.spring.rest.mvc.springbootrest.service.StudentRegistrationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentRegistrationController {
    StudentRegistrationService studentRegistrationService;

    public StudentRegistrationController(StudentRegistrationService studentRegistrationService) {
        this.studentRegistrationService = studentRegistrationService;
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public StudentRegistrationDTOList getAllStudent(){
        return new StudentRegistrationDTOList( studentRegistrationService.getAllStudent());
    }
    @GetMapping("{name}")
    @ResponseStatus(HttpStatus.OK)
    public StudentRegistrationDTO getByName(@PathVariable String name){
        return studentRegistrationService.getByName(name);
    }
@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudentRegistrationDTO createStudent(@RequestBody StudentRegistrationDTO studentRegistrationDTO){
        return  studentRegistrationService.createStudent(studentRegistrationDTO);
}
@GetMapping("/findbyid/{id}")
@ResponseStatus(HttpStatus.OK)
    public StudentRegistrationDTO getById(@PathVariable int id){
        return studentRegistrationService.getById(id);
}

@PutMapping("/{id}")
@ResponseStatus(HttpStatus.OK)
    public  StudentRegistrationDTO update(@PathVariable int id,@RequestBody StudentRegistrationDTO  studentRegistrationDTO){
        return studentRegistrationService.saveStudentByDTO(id,studentRegistrationDTO);
}
@PatchMapping("{id}")
@ResponseStatus(HttpStatus.OK)
    StudentRegistrationDTO patch(@PathVariable int id,@RequestBody StudentRegistrationDTO  studentRegistrationDTO){
    return  studentRegistrationService.patchCustomer(id,studentRegistrationDTO);
}
@DeleteMapping("/{id}")
@ResponseStatus(HttpStatus.OK)
void delete(@PathVariable int id) {
         studentRegistrationService.deleteStudentById(id);
}
}
