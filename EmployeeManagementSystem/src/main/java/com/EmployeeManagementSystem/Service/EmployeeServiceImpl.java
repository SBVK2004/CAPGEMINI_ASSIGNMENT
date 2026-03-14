package com.EmployeeManagementSystem.Service;

import com.EmployeeManagementSystem.Pojo.Employee;

// use your actual package name

public class EmployeeServiceImpl implements EmployeeService {

    // Employee object injected by Spring IoC (Setter Injection)
    private Employee employee;

    // Default constructor
    public EmployeeServiceImpl() {}

    // Setter for Spring IoC injection
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public void addEmployee() {
        System.out.println("=== Add Employee ===");
        System.out.println(employee.toString());
        System.out.println("Employee added successfully!\n");
    }

    @Override
    public void updateEmployee() {
        System.out.println("=== Update Employee ===");
        System.out.println("Updating employee: " + employee.getName());
        System.out.println("Employee updated successfully!\n");
    }

    @Override
    public void deleteEmployee() {
        System.out.println("=== Delete Employee ===");
        System.out.println("Deleting employee with ID: " + employee.getId());
        System.out.println("Employee deleted successfully!\n");
    }

    @Override
    public void getEmployee() {
        System.out.println("=== Get Employee Details ===");
        System.out.println(employee.toString());
        System.out.println();
    }
}