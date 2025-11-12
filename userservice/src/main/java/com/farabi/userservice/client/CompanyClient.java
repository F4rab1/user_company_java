package com.farabi.userservice.client;

import com.farabi.userservice.dtos.CompanyDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "companyservice", url = "${company.service.url}")
public interface CompanyClient {

    @GetMapping("/api/companies/{id}")
    CompanyDto getCompanyById(@PathVariable("id") Long id);
}
