package com.hsf302.shopbear.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hsf302.shopbear.pojos.Products;

import java.util.List;
import java.util.Optional;
import java.util.Set;


public interface ProductRepository extends JpaRepository<Products, Integer> {
    Optional<Products> findById(Long id);

}
