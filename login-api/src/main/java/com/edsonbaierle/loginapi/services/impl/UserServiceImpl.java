package com.edsonbaierle.loginapi.services.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.edsonbaierle.loginapi.dtos.UserDto;
import com.edsonbaierle.loginapi.infra.exeptions.UserFoundException;
import com.edsonbaierle.loginapi.infra.exeptions.UserNotFoundException;
import com.edsonbaierle.loginapi.models.User;
import com.edsonbaierle.loginapi.repositores.UserRepository;
import com.edsonbaierle.loginapi.services.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository UserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDto saveUser(UserDto UserDto) {

        User UserJaExiste = UserRepository.findByEmail(UserDto.email());

        if (UserJaExiste != null) {
            throw new UserFoundException();
        }

        var passwordHash = passwordEncoder.encode(UserDto.password());

        User entity = new User(UserDto.name(), UserDto.email(), passwordHash, UserDto.role());

        User novoUser = UserRepository.save(entity);

        return new UserDto(novoUser.getName(), novoUser.getEmail(), novoUser.getPassword(), novoUser.getRole());
    }

    @Override
    public UserDto foundUser(String email){
        User userExist = UserRepository.findByEmail(email);

        if(userExist == null){
            throw new UserNotFoundException();
        }

        return new UserDto(userExist.getName(), userExist.getEmail(), userExist.getPassword(), userExist.getRole());
    }
}