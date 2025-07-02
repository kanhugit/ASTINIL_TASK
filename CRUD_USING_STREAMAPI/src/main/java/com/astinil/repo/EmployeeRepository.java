package com.astinil.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.astinil.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

