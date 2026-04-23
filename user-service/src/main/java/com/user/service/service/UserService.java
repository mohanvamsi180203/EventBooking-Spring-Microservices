package com.user.service.service;

import java.util.List;

import com.user.service.dto.UserResponseDto;
import com.user.service.entity.User;

public interface UserService {

	 User addUser(User user);

	    User updateUser(Integer id, User user);

	    String deleteUser(Integer id);

	    UserResponseDto getById(Integer id);

	    List<UserResponseDto> viewAll();

	    UserResponseDto getByEmail(String email);

	    List<UserResponseDto> getByName(String name);

	    List<UserResponseDto> getByCity(String city);

	    User getUserEntityById(Integer id);

	    User login(String email, String password);
}