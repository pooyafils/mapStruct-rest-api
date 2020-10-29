package com.spring.rest.mvc.springbootrest.repository;

import com.spring.rest.mvc.springbootrest.domain.StudentRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface StudentRegistrationRepository extends JpaRepository<StudentRegistration,Integer> {
    StudentRegistration findByName(String Name);
    StudentRegistration findById(int id);
}
