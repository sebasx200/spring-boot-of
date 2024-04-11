package com.example.springcrudof.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springcrudof.domain.Role;
import com.example.springcrudof.domain.User;
import com.example.springcrudof.dto.UserRegisterDTO;
import com.example.springcrudof.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(UserRegisterDTO userRegisterDTO) {
        User user = new User(userRegisterDTO.getName(), userRegisterDTO.getLast_name(), userRegisterDTO.getEmail(), userRegisterDTO.getPassword(), Arrays.asList(new Role("ROLE_USER")));
        return userRepository.save(user);
    }

}
