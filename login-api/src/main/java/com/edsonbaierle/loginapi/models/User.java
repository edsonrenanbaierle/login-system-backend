package com.edsonbaierle.loginapi.models;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.edsonbaierle.loginapi.enums.RoleEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "User")
public class User implements UserDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", unique = true)
  private Long id;

  @Column(name = "name", nullable = false, length = 100, unique = false)
  private String name;

  @Column(name = "email", nullable = false, length = 60, unique = true)
  private String email;

  @Column(name = "password", nullable = false, length = 100, unique = false)
  private String password;

  @Column(nullable = false)
  private RoleEnum role;

  public User(String name, String email, String password, RoleEnum role) {
    this.name = name;
    this.email = email;
    this.password = password;
    this.role = role;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    if(this.role == RoleEnum.ADMIN){
      return List.of(
        new SimpleGrantedAuthority("ROLE_ADMIN"),
        new SimpleGrantedAuthority("ROLE_USER")
      );
    }
    return List.of(
      new SimpleGrantedAuthority("ROLE_USER")
    );
  }

  @Override
  public String getUsername() {
    return this.email;
  }

  @Override
  public String getPassword() {
    return this.password;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

}
