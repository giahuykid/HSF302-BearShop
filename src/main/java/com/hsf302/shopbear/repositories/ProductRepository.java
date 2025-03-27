package com.hsf302.shopbear.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hsf302.shopbear.pojos.Products;


public interface ProductRepository extends JpaRepository<Products, Long> {
    Products getById(Long id);
    boolean existsById(Long id);

}
