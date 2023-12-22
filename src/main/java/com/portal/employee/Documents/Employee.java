package com.portal.employee.Documents;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Employee {
    @Id
    private String empId;
}
