package com.edsonbaierle.loginapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.edsonbaierle.loginapi.dtos.AuthDto;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

  @Autowired
  private AuthenticationManager authenticationManager;

  @PostMapping
  @ResponseStatus(HttpStatus.OK)
  public String auth(@RequestBody AuthDto AuthDto) {
    var UserAuthenticationToken = new UsernamePasswordAuthenticationToken(AuthDto.email(), AuthDto.password());
    authenticationManager.authenticate(UserAuthenticationToken);

    return "token...";
  }
}
