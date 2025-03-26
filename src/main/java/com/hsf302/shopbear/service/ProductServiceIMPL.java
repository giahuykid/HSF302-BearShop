package com.hsf302.shopbear.service;

import com.hsf302.shopbear.pojos.Colors;
import com.hsf302.shopbear.pojos.Products;
import com.hsf302.shopbear.pojos.Sizes;
import com.hsf302.shopbear.repositories.ColorRepository;
import com.hsf302.shopbear.repositories.ProductRepository;
import com.hsf302.shopbear.repositories.SizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceIMPL  implements ProductService{

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private SizeRepository sizeRepository;
    @Autowired
    private ColorRepository colorRepository;
    @Override
    public Products createProduct(Products products) {

            return productRepository.save(products);

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
    public Sizes getSizesById(String SizeId) {
        return Optional.ofNullable(SizeId)
                .filter(id -> id.matches("\\d+"))
                .map(Integer::parseInt)
                .flatMap(sizeRepository::findById)
                .orElse(null);
    }


    @Override
    public Products getProductById(String productId) {
        return Optional.ofNullable(productId)
                .filter(id -> id.matches("\\d+"))
                .map(Integer::parseInt)
                .flatMap(productRepository::findById)
                .orElse(null);
    }

    @Override
    public Colors getColorsById(String colorId) {
        return Optional.ofNullable(colorId)
                .filter(id -> id.matches("\\d+"))
                .map(Integer::parseInt)
                .flatMap(colorRepository::findById)
                .orElse(null);
    }


}
