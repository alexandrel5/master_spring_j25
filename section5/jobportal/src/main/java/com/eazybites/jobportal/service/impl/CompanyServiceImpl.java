package com.eazybites.jobportal.service.impl;

import com.eazybites.jobportal.entity.Company;
import com.eazybites.jobportal.repository.CompanyRepository;
import com.eazybites.jobportal.service.ICompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements ICompanyService {

    private final CompanyRepository companyRepository;

//    public CompanyServiceImpl(CompanyRepository companyRepository) {
//        this.companyRepository = companyRepository;
//    }

    @Override
    public List<Company> getALlCompany() {
        return companyRepository.findAll();
    }
}
