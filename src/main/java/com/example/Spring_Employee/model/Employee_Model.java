package com.example.Spring_Employee.model;

import jakarta.persistence.*;

@Entity
@Table(name = "employees") // Ensures table is created with a clear name
public class Employee_Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String designation;
    private int number;
    private int salary;

    // Constructors
    public Employee_Model() {}

    public Employee_Model(String name, String email, String designation, int number, int salary) {
        this.name = name;
        this.email = email;
        this.designation = designation;
        this.number = number;
        this.salary = salary;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getDesignation() { return designation; }
    public void setDesignation(String designation) { this.designation = designation; }

    public int getNumber() { return number; }
    public void setNumber(int number) { this.number = number; }

    public int getSalary() { return salary; }
    public void setSalary(int salary) { this.salary = salary; }
}