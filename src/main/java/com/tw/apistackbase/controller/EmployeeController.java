package com.tw.apistackbase.controller;

import com.tw.apistackbase.modle.Employee;
import com.tw.apistackbase.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("employeeController")
public class EmployeeController {

    private final Logger log = Logger.getLogger(this.getClass().getName());

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> list(){
        return employeeService.list();
    }

    @GetMapping("/employees/{index}")
    public Employee getEmployeeByIndex(@PathVariable int index){
        return employeeService.getEmployeeByIndex(index);
    }

    @PostMapping("/employees")
    public Employee getNewEmployee(@RequestBody Employee employee){
        return employeeService.getNewEmployee(employee);
    }

    @GetMapping(value = "/employees",params = {"page","pageSize"})
    private List<Employee> getEmployeeBetweenPageAddSize(@RequestParam int page,@RequestParam int pageSize){
        return employeeService.getEmployeeBetweenPageAddSize(page,pageSize);
    }

    @DeleteMapping("/employees/{index}")
    public Employee deleteEmployee(@PathVariable int index){
        return employeeService.deleteEmployee(index);
    }

    @PutMapping("/employees/{index}")
    public Employee updateEmployee(@RequestBody Employee employee,@PathVariable int index){
        return employeeService.updateEmployee(employee,index);
    }

    @GetMapping(value = "/employees" ,params = "gender")
    public List<Employee> findEmployeeSmallerThanAge(@RequestParam String gender){
        return employeeService.selectAllEmployeeByGender(gender);
    }


}