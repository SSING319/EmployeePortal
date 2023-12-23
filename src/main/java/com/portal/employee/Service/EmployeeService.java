package com.portal.employee.Service;

import java.util.List;

import java.util.Optional;
import org.springframework.stereotype.Service;
import com.portal.employee.Documents.Employee;
import com.portal.employee.repository.EmployeeRepo;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepo employeeRepo;

    public List<Employee> getAllEmployees(){
        return employeeRepo.findAll();
    }

    public Employee getEmployeeById(String id){
        Optional<Employee> employee = employeeRepo.findById(id);
        return employee.orElse(null);
    }

    public Employee addEmployee(Employee employee){
        return employeeRepo.save(employee);
    }

}
