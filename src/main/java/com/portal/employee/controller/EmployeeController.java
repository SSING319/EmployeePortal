package com.portal.employee.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portal.employee.Documents.Employee;
import com.portal.employee.Service.EmployeeService;

import lombok.RequiredArgsConstructor;

//all employee, by id, update , delete
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/portal")
public class EmployeeController{

    private final EmployeeService service;
    

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        service.getAllEmployees();
        return ResponseEntity.ok(service.getAllEmployees());
    }

    @GetMapping("/employee/{empId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable String empId){
        return ResponseEntity.ok(service.getEmployeeById(empId));
    }

    @PostMapping("/employee/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        return ResponseEntity.ok(service.addEmployee(employee));
    }

    // @PatchMapping
    // public ResponseEntity<Employee> updateEmployee(){
    //     return null;
    // }
    
    // @DeleteMapping
    // public ResponseEntity<Employee> deleteEmployee(){
    //     return null;
    // }
    
}