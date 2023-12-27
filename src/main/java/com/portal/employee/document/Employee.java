package com.portal.employee.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Document
public class Employee {
    @Id
    private String empId;
    private String empName;
    private String empDepartment;
}
