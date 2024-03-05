package com.edsonbaierle.loginapi.dtos;

import com.edsonbaierle.loginapi.enums.RoleEnum;

public record UserDto(
  String name,
  String email,
  String password,
  RoleEnum role
) {
  
}
