package com.example.springcrudof.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springcrudof.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    
}
