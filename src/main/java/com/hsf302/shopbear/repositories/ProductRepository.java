package com.hsf302.shopbear.repositories;

import com.hsf302.shopbear.pojos.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hsf302.shopbear.pojos.Products;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Products, Integer> {
    Optional<Products> findById(Long id);

}
