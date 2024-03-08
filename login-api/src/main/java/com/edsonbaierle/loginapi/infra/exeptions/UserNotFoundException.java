package com.edsonbaierle.loginapi.infra.exeptions;

public class UserNotFoundException extends RuntimeException{
  public UserNotFoundException(){
    super("Usuario não encontrado!");
  }
}
