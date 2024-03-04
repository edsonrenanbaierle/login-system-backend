package com.edsonbaierle.loginapi.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.edsonbaierle.loginapi.dtos.AuthDto;
import com.edsonbaierle.loginapi.repositores.UserRepository;
import com.edsonbaierle.loginapi.services.AuthenticationService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService{

  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    return userRepository.findByEmail(email);
  }

  @Override
  public String GenerateToken(AuthDto authDto) {
    return null;
  }
  
}
