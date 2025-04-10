package com.farabi.userservice.dto;

public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private CompanyDto company;

    public UserDto() {}

    public UserDto(Long id, String firstName, String lastName, String phoneNumber, CompanyDto company) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.company = company;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public CompanyDto getCompany() {
        return company;
    }
    public void setCompany(CompanyDto company) {
        this.company = company;
    }
}
