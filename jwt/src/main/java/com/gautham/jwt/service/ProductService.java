package com.gautham.jwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gautham.jwt.model.Product;
import com.gautham.jwt.repo.ProductRepo;

@Service
public class ProductService {

    @Autowired
    private ProductRepo repo;

    public List<Product> getAllProducts(){
        return repo.findAll();
    }

    public Product getProductByName(String productName){
        return repo.findByProductName(productName);
    }

    public String addProduct(Product product){
        Product prod = repo.save(product);
        if(prod == null){
            return "Failed to Save";
        }
        return "Saved product";
    }


}
