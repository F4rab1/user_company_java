package com.farabi.userservice.services;

import com.farabi.userservice.client.CompanyClient;
import com.farabi.userservice.dtos.CompanyDto;
import com.farabi.userservice.dtos.UserDto;
import com.farabi.userservice.entities.User;
import com.farabi.userservice.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final CompanyClient companyClient;

    public UserService(UserRepository userRepository, CompanyClient companyClient) {
        this.userRepository = userRepository;
        this.companyClient = companyClient;
    }

    public UserDto createUser(UserDto userDto) {
        User user = convertToEntity(userDto);
        User savedUser = userRepository.save(user);
        return convertToDto(savedUser);
    }

    public UserDto getUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return convertToDto(user);
    }

    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public UserDto updateUser(Long id, User updatedUser) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setFirstName(updatedUser.getFirstName());
        user.setLastName(updatedUser.getLastName());
        user.setPhoneNumber(updatedUser.getPhoneNumber());
        user.setCompanyId(updatedUser.getCompanyId());

        User saved = userRepository.save(user);
        return convertToDto(saved);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    private User convertToEntity(UserDto userDto) {
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPhoneNumber(userDto.getPhoneNumber());
        return user;
    }

    private UserDto convertToDto(User user) {
        CompanyDto company = null;

        if (user.getCompanyId() != null) {
            company = companyClient.getCompanyById(user.getCompanyId());
        }

        return new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getPhoneNumber(),
                company
        );
    }
}
