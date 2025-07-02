package com.astinil.model;



import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double salary;
    private String department;
    private String phone;

    public Employee() {}

    public Employee(String name, double salary, String department, String phone) {
        this.name = name;
        this.salary = salary;
        this.department = department;
        this.phone = phone;
    }

    // Getters and Setters
    // (Can be generated via Lombok as well)
    
    public Long getId() { return id; }
    public String getName() { return name; }
    public double getSalary() { return salary; }
    public String getDepartment() { return department; }
    public String getPhone() { return phone; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setSalary(double salary) { this.salary = salary; }
    public void setDepartment(String department) { this.department = department; }
    public void setPhone(String phone) { this.phone = phone; }
}
