package com.hsf302.shopbear.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hsf302.shopbear.pojos.Products;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Products, Integer> {

}
