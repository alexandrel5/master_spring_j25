package com.eazybites.jobportal.company.controller;

import com.eazybites.jobportal.dto.CompanyDto;
import com.eazybites.jobportal.entity.Company;
import com.eazybites.jobportal.service.ICompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/companies")
@RequiredArgsConstructor
public class CompanyController {

    private final ICompanyService companyService;

//    @Autowired// Optional
//    private CompanyController(ICompanyService companyService) {
//        this.companyService = companyService;
//    }

    @GetMapping(version = "1.0")
    public ResponseEntity<List<CompanyDto>> getAllCompanies(){

        List<CompanyDto> companiesList = companyService.getALlCompany();
        return ResponseEntity.ok().body(companiesList);
    }
}
