package com.hr.app.service;

import com.hr.app.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Optional<Employee> getEmployeeById(Integer id);
    Employee updateEmployee(Employee employee);
    void deleteEmployee(Integer id);
    List<Employee> importEmployeesFromXml(String xmlData);
}
