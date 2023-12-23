package com.portal.employee.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.portal.employee.Documents.Employee;

@Repository
public interface EmployeeRepo extends MongoRepository<Employee, String> {
    
}
    

