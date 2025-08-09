package com.hr.app.controller;


import com.hr.app.model.Employee;
import com.hr.app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/import")
public class ImportController {

    private final EmployeeService employeeService;

    @Autowired
    public ImportController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/xml")
    public ResponseEntity<List<Employee>> importXmlData(@RequestBody String xmlData) {
        List<Employee> employees = employeeService.importEmployeesFromXml(xmlData);
        return new ResponseEntity<>(employees, HttpStatus.CREATED);
    }
}
