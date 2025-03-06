package com.hsf302.shopbear.service;

import com.hsf302.shopbear.pojos.Products;
import com.hsf302.shopbear.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceIMPL  implements ProductService{

    @Autowired
    private ProductRepository productRepository;
    @Override
    public Products createProduct(Products products) {
        if (check(products.getProductId())==null){
            productRepository.save(products);
        }
        return null;
    }

    @Override
    public Products check(long id) {
        return productRepository.findById(id).orElse(null);
    }
}
