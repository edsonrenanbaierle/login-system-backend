package com.edsonbaierle.loginapi.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.edsonbaierle.loginapi.dtos.UserDto;
import com.edsonbaierle.loginapi.models.User;
import com.edsonbaierle.loginapi.repositores.UserRepository;
import com.edsonbaierle.loginapi.services.UserService;

@Service
public class UserServiceImpl implements UserService{

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private UserRepository UserRepository;

  @Override
  public UserDto saveUser(UserDto UserDto) {
    var passwordHash = passwordEncoder.encode(UserDto.password());

    User entity = new User(UserDto.name(), UserDto.email(), passwordHash, UserDto.role());
    User newUser = UserRepository.save(entity);

    return new UserDto(newUser.getName(), newUser.getEmail(), newUser.getPassword(), newUser.getRole());
  }

}
