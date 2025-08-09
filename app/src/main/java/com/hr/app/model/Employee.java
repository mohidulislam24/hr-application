package com.hr.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    private Integer id;
    private String firstName;
    private String lastName;
    private String title;
    private String division;
    private String building;
    private String room;
}
