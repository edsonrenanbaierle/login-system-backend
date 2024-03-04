package com.edsonbaierle.loginapi.dtos;

public record UserDto(
  String name,
  String email,
  String password
) {
  
}
