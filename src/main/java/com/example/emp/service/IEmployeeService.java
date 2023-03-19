package com.example.emp.service;

import com.example.emp.dto.EmployeeDto;
import com.example.emp.entity.Employee;

import java.util.List;

public interface IEmployeeService
{
    Employee insert(EmployeeDto employeeDto);
    Employee getById(int id);
    List<Employee> findAll();
    Employee update(EmployeeDto employeeDto, int id);
    String deleteByID(int id);
    List<Employee> getNames(String name);
    List<Employee> getByDepartment(String department);
}

