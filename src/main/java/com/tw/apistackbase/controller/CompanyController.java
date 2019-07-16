package com.tw.apistackbase.controller;

import com.tw.apistackbase.modle.Company;
import com.tw.apistackbase.modle.Employee;
import com.tw.apistackbase.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompanyController {

    @Autowired
    CompanyRepository companyRepository;

    @GetMapping("/companies")
    public List<Company> getCompanyList(){
        return companyRepository.getAllCompany();
    }

    @GetMapping("/companies/{index}")
    public Company getCompanyByIndex(@PathVariable int index){
        return companyRepository.getCompanyByIndex(index);
    }

    @GetMapping("/companies/{index}/employees")
    public List<Employee> getCertainCompanyAllEmployees(@PathVariable int index){
        return companyRepository.getCertainCompanyAllEmployee(index);
    }

    @GetMapping(value = "/companies",params = "page")
    public List<Company> getCompanyBetweenPageToAddSize(@RequestParam int page){
        return companyRepository.getCompanyBetweenPageToAddSize(page,2);
    }

    @PostMapping("/companies")
    private List<Company> addNewCompany(@RequestBody Company company){
        return companyRepository.addNewCompany(company);
    }

    @PutMapping("/companies/{index}")
    public List<Company> updateCompanyMessage(@PathVariable int index,@RequestBody Company company){
        return companyRepository.updateCompanyMessage(index,company);
    }

    @DeleteMapping("/companies/{index}")
    public List<Company> deleteCompany(@PathVariable int index){
        return companyRepository.deleteCompany(index);
    }


}
