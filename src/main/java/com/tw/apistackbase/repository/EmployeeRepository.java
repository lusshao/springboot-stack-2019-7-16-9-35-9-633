package com.tw.apistackbase.repository;

import com.tw.apistackbase.modle.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class EmployeeRepository {
    private static List<Employee> employeeList;

    static {
        employeeList = new ArrayList<>();
        Employee employee = new Employee();
        employeeList.add(createEmployee(1));
        employeeList.add(createEmployee(2));
        employeeList.add(createEmployee(3));
        employeeList.add(createEmployee(4));
    }

    public static Employee createEmployee(int id) {
        Employee employee = new Employee();
        employee.setAge(18);
        employee.setGender("Female");
        employee.setName("la");
        employee.setId(id);
        employee.setSalary(8000);
        return employee;
    }

    public List<Employee> getEmployeeList(){
        return employeeList;
    }

}
