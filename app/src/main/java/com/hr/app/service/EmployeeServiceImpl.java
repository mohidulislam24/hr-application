package com.hr.app.service;


import com.hr.app.model.Employee;
import com.hr.app.repo.EmployeeRepository;
import com.hr.app.utils.XmlImportUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeById(Integer id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> importEmployeesFromXml(String xmlData) {
        List<Employee> employees = XmlImportUtil.parseXml(xmlData);
        return employeeRepository.saveAll(employees);
    }
}
