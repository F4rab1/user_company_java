package com.farabi.userservice.mappers;

import com.farabi.userservice.client.CompanyClient;
import com.farabi.userservice.dtos.CompanyDto;
import com.farabi.userservice.dtos.UserDto;
import com.farabi.userservice.entities.User;
import org.mapstruct.AfterMapping;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toUserDto(User user, @Context CompanyClient companyClient);

    User toUserEntity(UserDto userDto);

    @AfterMapping
    default void mapCompany(User user, @MappingTarget UserDto userDto, @Context CompanyClient companyClient) {
        if (user.getCompanyId() != null) {
            userDto.setCompany(companyClient.getCompanyById(user.getCompanyId()));
        }
    }
}
