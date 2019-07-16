package com.tw.apistackbase.controller;

import com.tw.apistackbase.modle.Company;
import com.tw.apistackbase.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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




}
