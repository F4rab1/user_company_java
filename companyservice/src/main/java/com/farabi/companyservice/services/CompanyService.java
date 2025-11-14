package com.farabi.companyservice.services;

import com.farabi.companyservice.dtos.CompanyDto;
import com.farabi.companyservice.entities.Company;
import com.farabi.companyservice.mappers.CompanyMapper;
import com.farabi.companyservice.repositories.CompanyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;

    public CompanyDto createCompany(CompanyDto companyDto) {
        Company company = companyMapper.toCompany(companyDto);
        Company createdCompany = companyRepository.save(company);
        return companyMapper.toCompanyDto(createdCompany);
    }

    public CompanyDto getCompanyById(Long id) {
        Company company = companyRepository.findById(id).orElse(null);

        if (company == null) {
            return null;
        }

        return companyMapper.toCompanyDto(company);
    }

    public List<CompanyDto> findAll() {
        System.out.println("company Mapper worked");
        return companyRepository.findAll().stream()
                .map(companyMapper::toCompanyDto)
                .collect(Collectors.toList());
    }

    public CompanyDto updateCompany(Long id, Company updatedCompany) {
        Company company = companyRepository.findById(id).orElse(null);
        if (company == null) {
            return null;
        }

        company.setName(updatedCompany.getName());
        company.setBudget(updatedCompany.getBudget());
        Company savedCompany = companyRepository.save(company);
        return companyMapper.toCompanyDto(savedCompany);
    }

    public void deleteCompanyById(Long id) {
        companyRepository.deleteById(id);
    }
}
