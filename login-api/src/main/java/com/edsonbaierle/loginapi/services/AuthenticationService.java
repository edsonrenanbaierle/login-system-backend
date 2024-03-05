package com.edsonbaierle.loginapi.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.edsonbaierle.loginapi.dtos.AuthDto;

public interface AuthenticationService extends UserDetailsService{
  public String GetToken(AuthDto authDto);
}
