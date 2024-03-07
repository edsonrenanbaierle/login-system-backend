package com.edsonbaierle.loginapi.infra.exeptions;

public class UserFoundException extends RuntimeException {
  public UserFoundException() {
  super("Usuario já existe");
  }
}