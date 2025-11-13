package com.farabi.companyservice.services;

import com.farabi.companyservice.dtos.CompanyDto;
import com.farabi.companyservice.entities.Company;
import com.farabi.companyservice.repositories.CompanyRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyDto createCompany(CompanyDto companyDto) {
        Company company = convertToEntity(companyDto);
        Company createdCompany = companyRepository.save(company);
        return convertToDto(createdCompany);
    }

    public CompanyDto getCompanyById(Long id) {
        Company company = companyRepository.findById(id).orElse(null);

        if (company == null) {
            return null;
        }

        return convertToDto(company);
    }

    public List<CompanyDto> findAll() {
        return companyRepository.findAll().stream()
                .map(this::convertToDto)
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
        return convertToDto(savedCompany);
    }

    public void deleteCompanyById(Long id) {
        companyRepository.deleteById(id);
    }

    private Company convertToEntity(CompanyDto companyDto) {
        Company company = new Company();
        company.setName(companyDto.getName());
        company.setBudget(companyDto.getBudget());
        return company;
    }

    private CompanyDto convertToDto(Company company) {
        return new CompanyDto(
                company.getId(),
                company.getName(),
                company.getBudget()
        );
    }
}
