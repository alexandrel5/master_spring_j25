package com.eazybites.jobportal.company.service;

import com.eazybites.jobportal.dto.CompanyDto;
import com.eazybites.jobportal.entity.Company;

import java.util.List;

public interface ICompanyService {
    List<CompanyDto> getALlCompany();
}
