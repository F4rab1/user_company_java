package com.farabi.companyservice.mappers;

import com.farabi.companyservice.dtos.CompanyDto;
import com.farabi.companyservice.entities.Company;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompanyMapper {
    CompanyDto toCompanyDto(Company company);
    Company toCompany(CompanyDto companyDto);
}
