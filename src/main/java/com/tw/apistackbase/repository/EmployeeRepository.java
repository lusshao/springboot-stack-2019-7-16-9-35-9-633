package com.tw.apistackbase.repository;

import com.tw.apistackbase.modle.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
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


    public Employee getEmployeeByIndex(int index) {
        return employeeList.get(index-1);
    }

    public Employee addNewEmployee(Employee employee) {
        employeeList.add(employee);
        return employee;
    }

    public Employee deleteEmployee(int index) {
        return employeeList.remove(index-1);
    }

    public Employee updateEmployee(Employee employee,int index) {
        employeeList.remove(index-1);
        employeeList.add(index-1,employee);
        return employee;
    }

    public List<Employee> selectAllEmployeeByGender(String gender) {
        return employeeList.stream().filter(x->x.getGender().equals(gender)).collect(Collectors.toList());
    }

    public List<Employee> getEmployeeBetweenPageAddSize(int page, int pageSize) {
        return employeeList.stream().skip(page-1).limit(pageSize).collect(Collectors.toList());
    }
}
