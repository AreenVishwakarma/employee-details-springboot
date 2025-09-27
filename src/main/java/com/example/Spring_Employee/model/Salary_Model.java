package com.example.Spring_Employee.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "incentive")
public class Salary_Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String designation;
    private int incentive;

    @Column(name = "date_time")
    private LocalDateTime dateTime;

    // Automatically set dateTime before persisting
    @PrePersist
    protected void onCreate() {
        this.dateTime = LocalDateTime.now();
    }

    public Salary_Model() {}

    public Salary_Model(String name, String email, String designation, int incentive, LocalDateTime dateTime) {
        this.name = name;
        this.email = email;
        this.designation = designation;
        this.incentive = incentive;
        this.dateTime = dateTime;
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

    public int getIncentive() { return incentive; }
    public void setIncentive(int incentive) { this.incentive = incentive; }

    public LocalDateTime getDateTime() { return dateTime; }
    public void setDateTime(LocalDateTime dateTime) { this.dateTime = dateTime; }
}