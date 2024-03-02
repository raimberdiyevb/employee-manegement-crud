package com.raim.demo_crud_thymeleaf.service;

import com.raim.demo_crud_thymeleaf.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);

}
