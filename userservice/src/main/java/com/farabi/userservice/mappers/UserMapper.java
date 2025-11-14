package com.farabi.userservice.mappers;

import com.farabi.userservice.client.CompanyClient;
import com.farabi.userservice.dtos.UserDto;
import com.farabi.userservice.dtos.UserRequestDto;
import com.farabi.userservice.entities.User;
import org.mapstruct.*;


@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toUserDto(User user, @Context CompanyClient companyClient);

    User toUserEntity(UserDto userDto);

    @Mapping(source = "company", target = "companyId")
    User toUserEntity(UserRequestDto userRequestDto);

    @AfterMapping
    default void mapCompany(User user, @MappingTarget UserDto userDto, @Context CompanyClient companyClient) {
        if (user.getCompanyId() != null) {
            userDto.setCompany(companyClient.getCompanyById(user.getCompanyId()));
        }
    }
}
