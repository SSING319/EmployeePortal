package com.portal.employee.Service;

import java.lang.reflect.Field;
import java.util.List;

import java.util.Map;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.portal.employee.document.Employee;
import com.portal.employee.repository.EmployeeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.util.ReflectionUtils;

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

    public Optional<Employee> updateEmployee(Employee originalEmployee, Map<String, Object> change) {
        return Optional.ofNullable(originalEmployee)
                .map(employee -> {
                    change.forEach((key, value) -> {
                        Field field = ReflectionUtils.findField(Employee.class, key);
                        if (field != null) {
                            field.setAccessible(true);
                            ReflectionUtils.setField(field, employee, value);
                        }
                    });
                    return employeeRepo.save(employee);
                });
    }
}
