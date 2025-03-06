package com.hsf302.shopbear.service;

import com.hsf302.shopbear.pojos.Products;

public interface ProductService {
    public Products createProduct(Products products);
    public Products check(long id);

}
