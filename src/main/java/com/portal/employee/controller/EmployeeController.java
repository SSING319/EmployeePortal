package com.portal.employee.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portal.employee.Documents.Employee;

//all employee, by id, update , delete

@RestController
public class EmployeeController{

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees(){
        return null;
    }

    @GetMapping
    public ResponseEntity<Employee> getEmployeeById(){
        return null;
    }

    @PostMapping
    public ResponseEntity<Employee> addEmployee(){
        return null;
    }

    @PatchMapping
    public ResponseEntity<Employee> updateEmployee(){
        return null;
    }
    
    @DeleteMapping
    public ResponseEntity<Employee> deleteEmployee(){
        return null;
    }
    
}