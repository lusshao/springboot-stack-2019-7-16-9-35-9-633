package com.tw.apistackbase.controller;

import com.tw.apistackbase.modle.Company;
import com.tw.apistackbase.modle.Employee;
import com.tw.apistackbase.service.CompanyService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.*;

import static org.hamcrest.Matchers.any;
import static org.hamcrest.Matchers.anything;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyObject;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
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
    void should_return_company_list_when_get_to_companyController_companies() throws Exception {
        Company company = new Company("lay",0,null);
        List<Company> companies = new ArrayList<>();
        companies.add(company);
        when(companyService.getCompanyList()).thenReturn(companies);

        ResultActions result = mockMvc.perform(get("/companyController/companies"));

        result.andExpect(status().isOk()).andExpect(jsonPath("$[0].companyName",is("lay")))
        .andExpect(jsonPath("$[0].employeeNumber",is(0)));;
    }

    @Test
    void should_return_company_when_get_to_companyController_companies_given_index() throws Exception {
        Company company = new Company("lay",0,null);
        when(companyService.getCompanyByIndex(anyInt())).thenReturn(company);

        ResultActions result = mockMvc.perform(get("/companyController/companies/{index}",1));

        result.andExpect(status().isOk()).andExpect(jsonPath("$.companyName",is("lay")))
                .andExpect(jsonPath("$.employeeNumber",is(0)));
    }

    @Test
    void should_return_employee_list_when_get_to_companyController_companies_1_employees() throws Exception {
        Employee employee  = new Employee(1,"lay",18,"male",8000);
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee);
        when(companyService.getCertainCompanyAllEmployees(anyInt())).thenReturn(employeeList);

        ResultActions result = mockMvc.perform(get("/companyController/companies/1/employees"));

        result.andExpect(status().isOk()).andExpect(jsonPath("$[0].id",is(1)))
                .andExpect(jsonPath("$[0].name",is("lay")))
                .andExpect(jsonPath("$[0].age",is(18)))
                .andExpect(jsonPath("$[0].gender",is("male")))
                .andExpect(jsonPath("$[0].salary",is(8000)));

    }

    @Test
    void should_return_employee_list_when_get_to_companyController_companies_given_two_integer() throws Exception {

        Company company = new Company("lay",0,null);
        List<Company> companies = new ArrayList<>();
        companies.add(company);
        when(companyService.getCompanyBetweenPageToAddSize(anyInt(),anyInt())).thenReturn(companies);

        ResultActions result = mockMvc.perform(get("/companyController/companies?page={page}&pageSize={pageSize}",1,1));

        result.andExpect(status().isOk()).andExpect(jsonPath("[0].companyName",is("lay")))
                .andExpect(jsonPath("[0].employeeNumber",is(0)));;

    }

    @Test
    void addNewCompany() throws Exception {

//        Company company = new Company("lay",0,null);
//        List<Company> companies = new ArrayList<>();
//        companies.add(company);
//        when(companyService.addCompany((Company) anything())).thenReturn(companies);
//
//        String paraJson = "{\n" +
//                "     \"companyName\": \"lay\",\n" +
//                "    \"employeeNumber\": 4,\n" +
//                "    \"employees\": []\n" +
//                "}";
//        ResultActions result = mockMvc.perform(post("/companyController/companies").contentType(MediaType.APPLICATION_JSON).content(paraJson));
//
//        result.andExpect(status().isOk());


    }

}