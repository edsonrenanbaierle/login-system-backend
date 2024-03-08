package com.edsonbaierle.loginapi.services;

import com.edsonbaierle.loginapi.dtos.UserDto;

public interface UserService {

  public UserDto saveUser(UserDto UserDto);

  public UserDto foundUser(String email);
}
