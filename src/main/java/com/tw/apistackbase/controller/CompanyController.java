package com.tw.apistackbase.controller;

import com.tw.apistackbase.modle.Company;
import com.tw.apistackbase.modle.Employee;
import com.tw.apistackbase.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("companyController")
public class CompanyController {

    private final Logger log = Logger.getLogger(this.getClass().getName());

    @Autowired
    CompanyService companyService;

    @GetMapping("/companies")
    public List<Company> getCompanyList(){
        return companyService.getCompanyList();
    }

    @GetMapping("/companies/{index}")
    public Company getCompanyByIndex(@PathVariable int index){
        return companyService.getCompanyByIndex(index);
    }

    @GetMapping("/companies/{index}/employees")
    public List<Employee> getCertainCompanyAllEmployees(@PathVariable int index){
        return companyService.getCertainCompanyAllEmployees(index);
    }

    @GetMapping(value = "/companies",params = "page")
    public List<Company> getCompanyBetweenPageToAddSize(@RequestParam int page){
        return companyService.getCompanyBetweenPageToAddSize(page,2);
    }

    @PostMapping("/companies")
    public List<Company> addNewCompany(@RequestBody Company company){
        return companyService.addCompany(company);
    }

    @PutMapping("/companies/{index}")
    public List<Company> updateCompanyMessage(@PathVariable int index,@RequestBody Company company){
        return companyService.updateCompanyMessage(index,company);
    }

    @DeleteMapping("/companies/{index}")
    public List<Company> deleteCompany(@PathVariable int index){
        return companyService.deleteCompany(index);
    }


}
