package com.pcg.gitdemo.repositories;

import com.pcg.gitdemo.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
