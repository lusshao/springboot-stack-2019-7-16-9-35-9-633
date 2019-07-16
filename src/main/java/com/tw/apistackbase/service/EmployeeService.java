package com.tw.apistackbase.service;

import com.tw.apistackbase.modle.Employee;
import com.tw.apistackbase.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> list(){
        return employeeRepository.getEmployeeList();
    }

    public Employee getEmployeeByIndex(@PathVariable int index){
        return employeeRepository.getEmployeeByIndex(index);
    }

    public Employee getNewEmployee(@RequestBody Employee employee){
        return employeeRepository.addNewEmployee(employee);
    }

    public Employee deleteEmployee(@PathVariable int index){
        return employeeRepository.deleteEmployee(index);
    }

    public Employee updateEmployee(Employee employee,int index){
        return employeeRepository.updateEmployee(employee,index);
    }


    public List<Employee> selectAllEmployeeByGender(String gender) {
        return employeeRepository.selectAllEmployeeByGender(gender);
    }

    public List<Employee> getEmployeeBetweenPageAddSize(int page, int pageSize) {
        return employeeRepository.getEmployeeBetweenPageAddSize(page,pageSize);
    }
}
