package com.hsf302.shopbear.service;

import com.hsf302.shopbear.pojos.Colors;

import com.hsf302.shopbear.pojos.Products;
import com.hsf302.shopbear.pojos.Sizes;
import com.hsf302.shopbear.repositories.ColorRepository;
import com.hsf302.shopbear.repositories.ProductRepository;
import com.hsf302.shopbear.repositories.SizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductServiceIMPL  implements ProductService{

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private SizeRepository sizeRepository;
    @Autowired
    private ColorRepository colorRepository;

    private final String UPLOAD_DIR = "src/main/resources/static/uploads/"; // Thay đổi đường dẫn theo cấu trúc dự án của bạn



    @Override
    public Products check(long productId) {
        return null;
    }


    @Override
    public List<Products> getAllProducts() {
        return productRepository.findAll();
    }
    @Override
    public Products updateProduct(Products product) {
        if (check(product.getId()) != null) {
            return productRepository.save(product);
        }
        return null;
    }

    @Override
    public void deleteProduct(long productId) {

    }
    @Override
    public void createProduct(Products product, MultipartFile imageFile) throws IOException {
        if (product == null) {
            throw new IllegalArgumentException("Product không được null");
        }

        if (imageFile != null && !imageFile.isEmpty()) {
            String fileName = UUID.randomUUID().toString() + "_" + imageFile.getOriginalFilename(); // Tạo tên file duy nhất
            Path filePath = Paths.get(UPLOAD_DIR, fileName);
            Files.copy(imageFile.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            product.setImagePath("/uploads/" + fileName); // Lưu đường dẫn tương đối vào cơ sở dữ liệu
        }
        productRepository.save(product);
    }


}

