package com.hsf302.shopbear.service;

import com.hsf302.shopbear.pojos.Products;
import com.hsf302.shopbear.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

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
    public Products check(long productId) {
        return productRepository.findById(productId).orElse(null);
    }

    @Override
    public List<Products> getAllProducts() {
        return productRepository.findAll();
    }
    @Override
    public Products updateProduct(Products product) {
        if (check(product.getProductId()) != null) {
            return productRepository.save(product);
        }
        return null;
    }

    @Override
    public void deleteProduct(long productId) {
        if (check(productId) != null) {
            productRepository.deleteById(Math.toIntExact(productId));
        }
    }

    @Override
    public Products findById(long productId) {
        Optional<Products> product = productRepository.findById(productId);
        return product.orElse(null);
    }

    @Override
    public List<Products> findByProductNameContaining(String keyword) {
        if (keyword != null && !keyword.trim().isEmpty()) {
            return productRepository.findByProductNameContainingIgnoreCase(keyword);
        }
        return productRepository.findAll();
    }


}
