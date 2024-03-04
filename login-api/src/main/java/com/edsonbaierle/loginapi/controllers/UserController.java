package com.edsonbaierle.loginapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edsonbaierle.loginapi.dtos.UserDto;
import com.edsonbaierle.loginapi.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserService UserService;

  @PostMapping
  private UserDto saveUser(@RequestBody UserDto UserDto){
    return UserService.saveUser(UserDto);
  }

  @GetMapping
  private String saverOk(){
    return "ok";
  }
}
