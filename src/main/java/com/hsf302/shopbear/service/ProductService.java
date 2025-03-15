package com.hsf302.shopbear.service;

import com.hsf302.shopbear.pojos.Products;

import java.util.List;
import java.util.Set;

public interface ProductService {
    public Products createProduct(Products products);
    public Products check(long productId);
    public List<Products> getAllProducts();
    public Products updateProduct(Products product);
    public void deleteProduct(long productId);
}
