package com.example.Spring_Employee.controller;

import com.example.Spring_Employee.model.Employee_Model;
import com.example.Spring_Employee.model.Salary_Model;
import com.example.Spring_Employee.repository.Employee_Repository;
import com.example.Spring_Employee.repository.Salary_Repository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employees")
public class Employee_Controller {

    @Autowired
    private Employee_Repository employeeRepo;

    @Autowired
    private Salary_Repository salaryRepo;

    /* ---------------- EMPLOYEE CRUD ---------------- */
    
    @GetMapping("/form")
    public String showEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee_Model());
        return "Add_Employee";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute Employee_Model employee) {
        employeeRepo.save(employee);
        return "redirect:/employees/list";
    }

    @GetMapping("/list")
    public String listEmployees(Model model) {
        model.addAttribute("employees", employeeRepo.findAll());
        return "View_Employee";
    }

    /* ---------------- SALARY CRUD ---------------- */

//    @GetMapping("/salary-form")
//    public String showSalaryForm(Model model) {
//        model.addAttribute("salary", new Salary_Model());
//        return "Salary_Log";
//    }
    @GetMapping("/salary-form")
    public String showSalaryForm(Model model) {
        List<Employee_Model> employees = employeeRepo.findAll(); // Fetch employees from DB
        model.addAttribute("employees", employees);
        model.addAttribute("salary", new Salary_Model());
        return "Salary_Log";
    }
    @GetMapping("/employee/{id}")
    @ResponseBody
    public Employee_Model getEmployeeById(@PathVariable Long id) {
        return employeeRepo.findById(id).orElse(null);
    }

//    @PostMapping("/salary-save")
//    public String saveSalary(@ModelAttribute Salary_Model salary) {
//        salaryRepo.save(salary);
//        return "redirect:/employees/salary-list";
//    }
    @PostMapping("/salary-save")
    public String saveSalary(@RequestParam("empId") Long empId,
                             @ModelAttribute Salary_Model salary) {
        Employee_Model employee = employeeRepo.findById(empId).orElse(null);
        if (employee != null) {
            salary.setName(employee.getName());
            salary.setEmail(employee.getEmail());
            salary.setDesignation(employee.getDesignation());
        }
        salaryRepo.save(salary);
        return "redirect:/employees/salary-list";
    }

    @GetMapping("/salary-list")
    public String listSalary(Model model) {
        model.addAttribute("salaries", salaryRepo.findAll()); // ✅ attribute name = "salaries"
        return "View_Salary";
    }

}

