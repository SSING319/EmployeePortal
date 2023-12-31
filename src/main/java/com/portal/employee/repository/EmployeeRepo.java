package com.portal.employee.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.portal.employee.document.Employee;

import java.util.Optional;

@Repository
public interface EmployeeRepo extends MongoRepository<Employee, String> {
}
    

