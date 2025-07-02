package com.astinil.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.astinil.model.Employee;
import com.astinil.repo.EmployeeRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public List<Employee> getEmployeesWithSalaryLessThan300000() {
        return repository.findAll().stream()
                .filter(emp -> emp.getSalary() < 300000)
                .collect(Collectors.toList());
    }

    public List<Employee> getEmployeesWithPhoneStartingWith80() {
        return repository.findAll().stream()
                .filter(emp -> emp.getPhone().startsWith("80"))
                .collect(Collectors.toList());
    }


    public Employee saveEmployee(Employee employee) {
        return repository.save(employee);
    }

    public List<Employee> saveAll(List<Employee> employees) {
        return repository.saveAll(employees);
    }
    
    
    
    public Employee updateEmployee(Long id, Employee updatedEmp) {
        return repository.findById(id).map(emp -> {
            emp.setName(updatedEmp.getName());
            emp.setSalary(updatedEmp.getSalary());
            emp.setDepartment(updatedEmp.getDepartment());
            emp.setPhone(updatedEmp.getPhone());
            return repository.save(emp);
        }).orElse(null);
    }

    public String deleteEmployee(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return "Employee with ID " + id + " deleted.";
        } else {
            return "Employee not found.";
        }
    }

}
