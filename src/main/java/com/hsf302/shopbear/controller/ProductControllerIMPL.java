package com.hsf302.shopbear.controller;

import com.hsf302.shopbear.pojos.Products;
import com.hsf302.shopbear.service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductControllerIMPL implements ProductController {
    @Autowired
    private ProductService productService;


    @GetMapping("/manageProduct")
    public ModelAndView manageProduct() {
        ModelAndView modelAndView = new ModelAndView("manageProductjsp");
        modelAndView.addObject("products", productService.getAllProducts());
        return modelAndView;
    }



}
