package com.farabi.userservice.dtos;

import lombok.Data;


@Data
public class CompanyDto {
    private Long id;
    private String name;
    private Double budget;
}
