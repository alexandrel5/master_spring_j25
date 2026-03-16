package com.eazybites.jobportal.company.service;

import com.eazybites.jobportal.dto.CompanyDto;
import com.eazybites.jobportal.entity.Company;

import java.util.List;

public interface ICompanyService {
    List<CompanyDto> getAllCompany();
    boolean createCompany(CompanyDto companyDto);
    List<CompanyDto> getAllCompaniesForAdmin();
    boolean updateCompanyDetails(Long id, CompanyDto companyDto);
    void deleteCompanyById(Long id);
}
