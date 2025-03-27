package com.hsf302.shopbear.service;

import com.hsf302.shopbear.pojos.Products;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public interface ProductService {
    public Products check(long productId);

    public List<Products> getAllProducts();

    public Products updateProduct(Products product);

    public void deleteProduct(long productId);

    public void createProduct(Products product, MultipartFile imageFile) throws IOException;
}