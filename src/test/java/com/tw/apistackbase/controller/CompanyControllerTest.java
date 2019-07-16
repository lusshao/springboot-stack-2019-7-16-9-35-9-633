package com.tw.apistackbase.controller;

import com.tw.apistackbase.modle.Company;
import com.tw.apistackbase.modle.Employee;
import com.tw.apistackbase.service.CompanyService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.is;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CompanyController.class)
class CompanyControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    CompanyService companyService;

    @Test
    void getCompanyList() throws Exception {
        Company company = new Company("lay",0,null);
        List<Company> companies = new ArrayList<>();
        companies.add(company);
        when(companyService.getCompanyList()).thenReturn(companies);

        ResultActions result = mockMvc.perform(get("/companyController/companies"));

        result.andExpect(status().isOk());
    }

    @Test
    void getCompanyByIndex() throws Exception {
        Company company = new Company("lay",0,null);
        when(companyService.getCompanyByIndex(anyInt())).thenReturn(company);

        ResultActions result = mockMvc.perform(get("/companyController/companies/{index}",1));

        result.andExpect(status().isOk()).andExpect(jsonPath("$.companyName",is("lay")))
                .andExpect(jsonPath("$.employeeNumber",is(0)));
    }

    @Test
    void getCertainCompanyAllEmployees() throws Exception {
        Company company = new Company("lay",0,null);
        when(companyService.getCertainCompanyAllEmployees(anyInt())).thenReturn(new ArrayList<>());

        ResultActions result = mockMvc.perform(get("/companyController/companies/1/employees"));

        result.andExpect(status().isOk());

    }

    @Test
    void getCompanyBetweenPageToAddSize() throws Exception {

        Company company = new Company("lay",0,null);
        List<Company> companies = new ArrayList<>();
        companies.add(company);
        when(companyService.getCompanyBetweenPageToAddSize(anyInt(),anyInt())).thenReturn(companies);

        ResultActions result = mockMvc.perform(get("/companyController/companies"));

        result.andExpect(status().isOk());

    }

    @Test
    void addNewCompany() throws Exception {

//        Company company = new Company("lay",0,null);
//        List<Company> companies = new ArrayList<>();
//        companies.add(company);
//        when(companyService.addCompany(any())).thenReturn(companies);
//
//        ResultActions result = mockMvc.perform(post("/companyController/companies",company));
//
//        result.andExpect(status().isOk());


    }

    @Test
    void updateCompanyMessage() {

    }

    @Test
    void deleteCompany() {

    }
}