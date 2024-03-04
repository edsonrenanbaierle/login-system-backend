package com.edsonbaierle.loginapi.repositores;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edsonbaierle.loginapi.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
