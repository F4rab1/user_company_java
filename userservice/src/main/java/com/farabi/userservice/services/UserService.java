package com.farabi.userservice.services;

import com.farabi.userservice.client.CompanyClient;
import com.farabi.userservice.dtos.CompanyDto;
import com.farabi.userservice.dtos.UserDto;
import com.farabi.userservice.dtos.UserRequestDto;
import com.farabi.userservice.entities.User;
import com.farabi.userservice.mappers.UserMapper;
import com.farabi.userservice.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final CompanyClient companyClient;
    private final UserMapper userMapper;

    public UserDto createUser(UserRequestDto userRequestDto) {
        User user = userMapper.toUserEntity(userRequestDto);
        User savedUser = userRepository.save(user);
        return userMapper.toUserDto(savedUser, companyClient);
    }

    public UserDto getUser(Long id) {
        System.out.println("user mapper worked");
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return userMapper.toUserDto(user, companyClient);
    }

    public List<UserDto> getAllUsers() {
        System.out.println("user mapper worked");
        return userRepository.findAll().stream()
                .map(user -> userMapper.toUserDto(user, companyClient))
                .collect(Collectors.toList());
    }

    public UserDto updateUser(Long id, UserRequestDto userRequestDto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setFirstName(userRequestDto.getFirstName());
        user.setLastName(userRequestDto.getLastName());
        user.setPhoneNumber(userRequestDto.getPhoneNumber());
        user.setCompanyId(userRequestDto.getCompany());

        User savedUser = userRepository.save(user);
        return userMapper.toUserDto(savedUser, companyClient);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
