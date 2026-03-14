package com.EmployeeManagementSystem.Main;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.EmployeeManagementSystem.Service.EmployeeService;

public class Main {

    public static void main(String[] args) {

       
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        EmployeeService employeeService =
                (EmployeeService) context.getBean("employeeServiceBean");

        employeeService.addEmployee();
        employeeService.getEmployee();
        employeeService.updateEmployee();
        employeeService.deleteEmployee();

        ((ClassPathXmlApplicationContext) context).close();
    }
}
