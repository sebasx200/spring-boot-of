package com.example.springcrudof.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springcrudof.model.Product;
import com.example.springcrudof.repository.ProductRepository;

@Service
public class ProductServive {
    
    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    public boolean existsById(Long id) {
        return productRepository.existsById(id);
    }
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + id));
    }
}
