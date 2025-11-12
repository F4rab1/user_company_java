package com.farabi.companyservice.controllers;

import com.farabi.companyservice.dtos.CompanyDto;
import com.farabi.companyservice.entities.Company;
import com.farabi.companyservice.services.CompanyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/{id}")
    public CompanyDto getCompanyById(@PathVariable Long id) {
        return companyService.getCompanyById(id);
    }

    @GetMapping
    public List<CompanyDto> getAllCompanies() {
        return companyService.findAll();
    }

    @PostMapping
    public ResponseEntity<CompanyDto> createCompany(@RequestBody Company company) {
        return ResponseEntity.ok(companyService.createCompany(company));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompanyById(@PathVariable Long id) {
        companyService.deleteCompanyById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompanyDto> updateCompany(@PathVariable Long id , @RequestBody Company company) {
        return ResponseEntity.ok(companyService.updateCompany(id, company));
    }

}
