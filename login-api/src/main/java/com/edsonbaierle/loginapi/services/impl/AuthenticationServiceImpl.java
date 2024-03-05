package com.edsonbaierle.loginapi.services.impl;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.edsonbaierle.loginapi.dtos.AuthDto;
import com.edsonbaierle.loginapi.models.User;
import com.edsonbaierle.loginapi.repositores.UserRepository;
import com.edsonbaierle.loginapi.services.AuthenticationService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    return userRepository.findByEmail(email);
  }

  @Override
  public String GetToken(AuthDto authDto) {
    User user = userRepository.findByEmail(authDto.email());

    return generateTokenJwt(user);
  }

  public String generateTokenJwt(User user) {
    try {

      Algorithm algorithm = Algorithm.HMAC256("my-secrety");

      return JWT.create()
          .withIssuer("auth-api")
          .withSubject(user.getEmail())
          .withExpiresAt(generateExpirationDate())
          .sign(algorithm);

    } catch (JWTCreationException e) {
      throw new RuntimeException("Erro ao gerar o token!" + e.getMessage());
    }
  }

  private Instant generateExpirationDate() {
    return LocalDateTime.now().plusHours(8).toInstant(ZoneOffset.of("-03:00"));
  }
}
