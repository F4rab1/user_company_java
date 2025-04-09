package com.farabi.companyservice.service;

import com.farabi.companyservice.model.Company;
import com.farabi.companyservice.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Company createCompany(Company company) {
        return companyRepository.save(company);
    }

    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    public Company updateCompany(Long id, Company updatedCompany) {
        Company company = getCompanyById(id);
        company.setName(updatedCompany.getName());
        company.setBudget(updatedCompany.getBudget());
        return companyRepository.save(company);
    }

    public void deleteCompanyById(Long id) {
        companyRepository.deleteById(id);
    }

}
