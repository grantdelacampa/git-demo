package com.pcg.gitdemo.services;

import com.pcg.gitdemo.models.Product;
import com.pcg.gitdemo.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> readProducts () {
        return productRepository.findAll();
    }

}