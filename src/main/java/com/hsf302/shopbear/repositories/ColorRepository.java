package com.hsf302.shopbear.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hsf302.shopbear.pojos.Colors;


public interface ColorRepository extends JpaRepository<Colors, Integer> {

}
