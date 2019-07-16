package com.tw.apistackbase.service;

import com.tw.apistackbase.modle.Company;
import com.tw.apistackbase.modle.Employee;
import com.tw.apistackbase.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    public List<Company> getCompanyList(){
        return companyRepository.getAllCompany();
    }

    public Company getCompanyByIndex(int index){
        return companyRepository.getCompanyByIndex(index);
    }

    public List<Employee> getCertainCompanyAllEmployees( int index){
        return companyRepository.getCertainCompanyAllEmployee(index);
    }

    public List<Company> getCompanyBetweenPageToAddSize(int page,int pageSize){
        return companyRepository.getCompanyBetweenPageToAddSize(page,pageSize);
    }

    public List<Company> addCompany(Company company){
        return companyRepository.addNewCompany(company);
    }

    public List<Company> updateCompanyMessage( int index, Company company){
        return companyRepository.updateCompanyMessage(index,company);
    }

    public List<Company> deleteCompany( int index){
        return companyRepository.deleteCompany(index);
    }


}
