package com.gautham.jwt.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gautham.jwt.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
    Product findByProductName(String productName);
}
