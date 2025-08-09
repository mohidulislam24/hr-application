package com.hr.app.utils;


import com.hr.app.model.Employee;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class XmlImportUtil {
    public static List<Employee> parseXml(String xmlData) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Employees.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            Employees employees = (Employees) jaxbUnmarshaller.unmarshal(new StringReader(xmlData));
            return employees.getEmployees();
        } catch (JAXBException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static class Employees {
        private List<Employee> employees = new ArrayList<>();

        public List<Employee> getEmployees() {
            return employees;
        }

        public void setEmployees(List<Employee> employees) {
            this.employees = employees;
        }
    }
}
