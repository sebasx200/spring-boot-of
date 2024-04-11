package com.example.springcrudof.service;

import com.example.springcrudof.domain.User;
import com.example.springcrudof.dto.UserRegisterDTO;

public interface UserService {

    public User saveUser(UserRegisterDTO userRegisterDTO);

}
