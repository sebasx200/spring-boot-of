package com.example.springcrudof.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springcrudof.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}


