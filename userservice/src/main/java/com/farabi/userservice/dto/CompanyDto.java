package com.farabi.userservice.dto;

import java.util.List;

public class CompanyDto {
    private Long id;
    private String name;
    private Double budget;
    private List<UserDto> users;

    public CompanyDto() {}

    public CompanyDto(Long id, String name, Double budget, List<UserDto> users) {
        this.id = id;
        this.name = name;
        this.budget = budget;
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }

    public List<UserDto> getUsers() {
        return users;
    }

    public void setUsers(List<UserDto> users) {
        this.users = users;
    }
}
