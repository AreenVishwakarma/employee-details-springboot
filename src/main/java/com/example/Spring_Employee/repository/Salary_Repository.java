package com.example.Spring_Employee.repository;

import com.example.Spring_Employee.model.Salary_Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Salary_Repository extends JpaRepository<Salary_Model, Long> {}
