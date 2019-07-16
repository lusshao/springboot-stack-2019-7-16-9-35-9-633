package com.tw.apistackbase.repository;

import com.tw.apistackbase.modle.Company;
import com.tw.apistackbase.modle.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CompanyRepository {


    private static List<Company> companyList = new ArrayList<>();
    static {
        companyList.add(createCompany("alibaba"));
        companyList.add(createCompany("wangyi"));
        companyList.add(createCompany("tengxun"));
        companyList.add(createCompany("baidu"));
        companyList.add(createCompany("oocl"));
        companyList.add(createCompany("lajigongsi"));
    }

    private static Company createCompany(String companyName) {
        EmployeeRepository employeeRepository = new EmployeeRepository();
        Company company = new Company();
        company.setCompanyName(companyName);
        company.setEmployeeNumber(4);
        company.setEmployees(employeeRepository.getEmployeeList());
        return company;
    }

    public List<Company> getAllCompany() {
        return companyList;
    }

    public Company getCompanyByIndex(int index) {
        return companyList.get(index-1);
    }

    public List<Employee> getCertainCompanyAllEmployee(int index) {
        return companyList.get(index).getEmployees();
    }

    public List<Company> getCompanyBetweenPageToAddSize(int page, int pageSize) {
        return companyList.stream().skip(page-1).limit(pageSize).collect(Collectors.toList());
    }

    public List<Company> addNewCompany(Company company) {
        companyList.add(company);
        return companyList;
    }

    public List<Company> updateCompanyMessage(int index, Company company) {
        companyList.remove(index-1);
        companyList.add(index-1,company);
        return companyList;
    }

    public List<Company> deleteCompany(int index) {
        companyList.remove(index-1);
        return companyList;
    }
}
