package com.tw.apistackbase.repository;

import com.tw.apistackbase.modle.Company;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

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
        Company company = new Company();
        company.setCompanyName(companyName);
        company.setEmployeeNumber(0);
        return company;
    }

    public List<Company> getAllCompany() {
        return companyList;
    }

    public Company getCompanyByIndex(int index) {
        return companyList.get(index-1);
    }
}
