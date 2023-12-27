package com.portal.employee.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.portal.employee.document.Employee;
import com.portal.employee.Service.EmployeeService;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/portal")
public class EmployeeController{

    private final EmployeeService service;

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        service.getAllEmployees();
        return new ResponseEntity(service.getAllEmployees(), HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping("/employee/{empId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable String empId){
        return new ResponseEntity(service.getEmployeeById(empId), HttpStatus.FOUND);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/employee/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        return new ResponseEntity(service.addEmployee(employee), HttpStatus.CREATED);
    }

     @PatchMapping("/employee/{id}")
     @PreAuthorize("hasAuthority('ROLE_ADMIN')")
     public ResponseEntity<Employee> updateEmployee(@PathVariable String id, @RequestBody Map<String, Object> change){
        Employee originalEmployee = service.getEmployeeById(id);
        Optional<Employee> updatedEmployee = service.updateEmployee(originalEmployee, change);
        return updatedEmployee.map(employee -> new ResponseEntity(updatedEmployee, HttpStatus.CREATED))
                .orElse(new ResponseEntity(HttpStatus.UNPROCESSABLE_ENTITY));
     }
    
}