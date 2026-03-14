package com.EmployeeManagementSystem.Main;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.EmployeeManagementSystem.Service.EmployeeService;

public class Main {

    public static void main(String[] args) {

        // Step 1: Load the Spring IoC container
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        // Step 2: Get EmployeeService bean from container
        EmployeeService employeeService =
                (EmployeeService) context.getBean("employeeServiceBean");

        // Step 3: Call all service methods
        employeeService.addEmployee();
        employeeService.getEmployee();
        employeeService.updateEmployee();
        employeeService.deleteEmployee();

        // Step 4: Close the context
        ((ClassPathXmlApplicationContext) context).close();
    }
}