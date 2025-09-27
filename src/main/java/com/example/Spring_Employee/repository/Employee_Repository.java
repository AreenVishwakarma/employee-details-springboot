package com.example.Spring_Employee.repository;

import com.example.Spring_Employee.model.Employee_Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Employee_Repository extends JpaRepository<Employee_Model, Long> {}
