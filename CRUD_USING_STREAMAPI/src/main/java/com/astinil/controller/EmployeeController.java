package com.astinil.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.astinil.model.Employee;
import com.astinil.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee emp) {
        return service.saveEmployee(emp);
    }

    @PostMapping("/addAll")
    public List<Employee> addAll(@RequestBody List<Employee> empList) {
        return service.saveAll(empList);
    }

    @GetMapping("/all")
    public List<Employee> getAllEmployees() {
        return service.getAllEmployees();
    }

    @GetMapping("/low-salary")
    public List<Employee> getLowSalary() {
        return service.getEmployeesWithSalaryLessThan300000();
    }

    
    @GetMapping("/phone-starts-80")
    public List<Employee> getEmployeesWithPhoneStartingWith80() {
        return service.getEmployeesWithPhoneStartingWith80();
    }
    
    @PutMapping("/update/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee emp) {
        return service.updateEmployee(id, emp);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        return service.deleteEmployee(id);
    }


}
