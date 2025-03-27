package com.hsf302.shopbear.service;

import com.hsf302.shopbear.pojos.Products;

import java.util.List;

public interface ProductService {
    public Products createProduct(Products products);
    public Products check(long productId);
    public List<Products> getAllProducts();
    public Products updateProduct(Products product);
    public void deleteProduct(long productId);
    public Products findById(long productId);
    public  List<Products> findByProductNameContaining(String keyword);

}
