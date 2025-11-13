package com.farabi.companyservice.dtos;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDto {
    private Long id;

    @NotBlank(message = "Company name required")
    @Size(max = 255, message = "Company name must be less than 255 characters")
    private String name;

    @NotNull(message = "Budget must be provided")
    @DecimalMin(value = "0.00", inclusive = true, message = "Budget must be positive")
    @Digits(integer = 36, fraction = 2, message = "Budget must have up to 36 digits before and 2 after the decimal point")
    private BigDecimal budget;
}
